package com.anuragkanwar.slackmessagebackend.service;

import com.anuragkanwar.slackmessagebackend.model.domain.Room;
import com.anuragkanwar.slackmessagebackend.model.domain.User;

import java.util.List;

public interface RoomService {
    Room save(Room room);

    boolean existsRoomByName(String name);

    Room getRoomById(Long id);

    Room addUserToRoom(Long userId, Long roomId);

    Room removeUserFromRoom(Long userId, Long roomId);

    Room addUsersToRoom(Long roomId, List<User> users);
}
