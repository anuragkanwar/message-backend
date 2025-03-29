package com.anuragkanwar.slackmessagebackend.service.impl;

import com.anuragkanwar.slackmessagebackend.model.domain.Room;
import com.anuragkanwar.slackmessagebackend.model.domain.User;
import com.anuragkanwar.slackmessagebackend.model.domain.Workspace;
import com.anuragkanwar.slackmessagebackend.model.dto.common.RoomDto;
import com.anuragkanwar.slackmessagebackend.model.dto.request.CreateRoomRequestDto;
import com.anuragkanwar.slackmessagebackend.model.enums.RoomType;
import com.anuragkanwar.slackmessagebackend.repository.RoomRepository;
import com.anuragkanwar.slackmessagebackend.service.RoomService;
import com.anuragkanwar.slackmessagebackend.service.UserService;
import com.anuragkanwar.slackmessagebackend.service.WorkspaceService;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;
import com.anuragkanwar.slackmessagebackend.socket.SocketSessionManager;
import com.anuragkanwar.slackmessagebackend.socket.model.RoomCreatedEvent;
import com.anuragkanwar.slackmessagebackend.utils.Utils;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final UserService userService;
    private final WorkspaceService workspaceService;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final SocketSessionManager socketSessionManager;
    private final SocketIOServer socketIOServer;
    private final RoomService roomService;

    public RoomServiceImpl(RoomRepository roomRepository, UserService userService,
                           WorkspaceService workspaceService,
                           ApplicationEventPublisher applicationEventPublisher,
                           SocketSessionManager socketSessionManager,
                           SocketIOServer socketIOServer, RoomService roomService) {
        this.roomRepository = roomRepository;
        this.userService = userService;
        this.workspaceService = workspaceService;
        this.applicationEventPublisher = applicationEventPublisher;
        this.socketSessionManager = socketSessionManager;
        this.socketIOServer = socketIOServer;
        this.roomService = roomService;
    }

    @Transactional
    public Room save(CreateRoomRequestDto requestDto) {
        Long userId =
                Utils.getCurrentUserIdFromAuthentication(SecurityContextHolder.getContext().getAuthentication());

        Workspace workspace = workspaceService.getReferenceById(requestDto.getWorkspaceId());
        User user = userService.getReferenceById(userId);
        Set<User> users = new HashSet<>(List.of(user));

        for (Long id : requestDto.getUsers()) {
            users.add(userService.getReferenceById(id));
        }
        Room room = roomRepository.save(
                Room.builder()
                        .roomType(requestDto.getRoomType())
                        .description(requestDto.getDescription())
                        .creator(user)
                        .name(requestDto.getName())
                        .users(users)
                        .workspace(workspace)
                        .build()
        );

        requestDto.getUsers().forEach(memberId -> {
            Set<UUID> sessions = socketSessionManager.getSessions(memberId);
            sessions.forEach(session -> {
                SocketIOClient client = socketIOServer.getClient(session);
                if (client != null) {
                    client.joinRoom(room.getId().toString());
                }
            });
        });


        applicationEventPublisher.
                publishEvent(new RoomCreatedEvent(
                        this,
                        SocketEvent.room_created,
                        RoomDto.toDto(room)
                ));
        return room;
    }

    @Override
    public boolean existsRoomByName(String name) {
        return roomRepository.existsRoomByName(name);
    }

    @Override
    public Room getRoomById(Long id) {
        return roomRepository.getRoomById(id);
    }

    @Override
    public Room getRoomWithChatsById(Long id) {
        return roomRepository.getRoomWithChatsById(id);
    }


    @Override
    public Room addUserToRoom(Long userId, Long roomId) {
        User user = userService.getUserById(userId);
        Room room = getRoomById(roomId);
        room.getUsers().add(user);
        return roomRepository.save(room);
    }

    @Override
    public Room removeUserFromRoom(Long userId, Long roomId) {
        User user = userService.getUserById(userId);
        Room room = getRoomById(roomId);
        room.getUsers().remove(user);
        return roomRepository.save(room);
    }

    @Override
    public Room addUsersToRoom(Long roomId, List<User> users) {
        List<User> user = new ArrayList<>();
        for (User user1 : users) {
            user.add(userService.getUserById(user1.getId()));
        }
        Room room = getRoomById(roomId);
        room.getUsers().addAll(user);
        return roomRepository.save(room);
    }

    @Override
    public Room deleteRoom(Long roomId) {
        return roomRepository.deleteRoomById(roomId);
    }

    @Override
    public Set<Room> getAllRoomByWorkspaceId(Long workspaceId) {
        return roomRepository.findByWorkspace_Id(workspaceId);
    }


    @Override
    public Room getReferenceById(Long id) {
        if (id == null)
            return null;
        return roomRepository.getReferenceById(id);
    }

    @Override
    public Room updateRoom(CreateRoomRequestDto requestDto, Long roomId) {

        Room existingRoom = roomRepository.getRoomById(roomId);

        if (requestDto.getName() != null) {
            existingRoom.setName(requestDto.getName());
        }
        if (requestDto.getDescription() != null) {
            existingRoom.setDescription(requestDto.getDescription());
        }
        if (requestDto.getRoomType() != null) {
            if (existingRoom.getRoomType() == RoomType.Private && requestDto.getRoomType() == RoomType.Public) {
                existingRoom.setRoomType(requestDto.getRoomType());
            }

            if (existingRoom.getRoomType() == RoomType.Public && requestDto.getRoomType() == RoomType.Private) {
                existingRoom.setRoomType(requestDto.getRoomType());
            }
        }
        return roomRepository.save(existingRoom);
    }
}
