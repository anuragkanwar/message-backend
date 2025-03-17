package com.anuragkanwar.slackmessagebackend.service;

import com.anuragkanwar.slackmessagebackend.model.domain.Room;
import com.anuragkanwar.slackmessagebackend.model.domain.User;

import java.util.List;

public interface RoomService {
    Room save(Room room);

    boolean existsRoomByName(String name);

    Room getRoomById(Long id);

}
