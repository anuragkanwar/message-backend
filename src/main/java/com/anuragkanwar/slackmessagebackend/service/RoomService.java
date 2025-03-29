package com.anuragkanwar.slackmessagebackend.service;

import com.anuragkanwar.slackmessagebackend.model.domain.Room;
import com.anuragkanwar.slackmessagebackend.model.domain.User;
import com.anuragkanwar.slackmessagebackend.model.dto.request.CreateRoomRequestDto;

import java.util.List;
import java.util.Set;

public interface RoomService {
    Room save(CreateRoomRequestDto requestDto);

    boolean existsRoomByName(String name);

    Room getRoomById(Long id);

    Room getRoomWithChatsById(Long id);

    Room addUserToRoom(Long userId, Long roomId);

    Room removeUserFromRoom(Long userId, Long roomId);

    Room addUsersToRoom(Long roomId, List<User> users);

    Room deleteRoom(Long roomId);

    Set<Room> getAllRoomByWorkspaceId(Long workspaceId);

    Room getReferenceById(Long id);

    Room updateRoom(CreateRoomRequestDto requestDto, Long roomId);
}
