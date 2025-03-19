package com.anuragkanwar.slackmessagebackend.service.impl;

import com.anuragkanwar.slackmessagebackend.model.domain.Room;
import com.anuragkanwar.slackmessagebackend.model.domain.User;
import com.anuragkanwar.slackmessagebackend.repository.RoomRepository;
import com.anuragkanwar.slackmessagebackend.service.RoomService;
import com.anuragkanwar.slackmessagebackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserService userService;

    public Room save(Room room) {
        Set<User> users = new HashSet<>();
        for (User user : room.getUsers()) {
            users.add(userService.getUserById(user.getId()));
        }
        room.setUsers(users);
        return roomRepository.save(room);
    }

    @Override
    public boolean existsRoomByName(String name) {
        return roomRepository.existsRoomByName(name);
    }

    @Override
    public Room getRoomById(Long id) {
        return roomRepository.getRoomsById(id);
    }


    @Override
    public Room addUserToRoom(Long userId, Long roomId) {
        User user = userService.getUserById(userId);
        Room room = getRoomById(roomId);
        room.getUsers().add(user);
        return save(room);
    }

    @Override
    public Room removeUserFromRoom(Long userId, Long roomId) {
        User user = userService.getUserById(userId);
        Room room = getRoomById(roomId);
        room.getUsers().remove(user);
        return save(room);
    }

    @Override
    public Room addUsersToRoom(Long roomId, List<User> users) {
        List<User> user = new ArrayList<>();
        for (User user1 : users) {
            user.add(userService.getUserById(user1.getId()));
        }
        Room room = getRoomById(roomId);
        room.getUsers().addAll(user);
        return save(room);
    }

}
