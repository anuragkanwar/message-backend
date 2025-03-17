package com.anuragkanwar.slackmessagebackend.service;

import com.anuragkanwar.slackmessagebackend.model.domain.Room;
import com.anuragkanwar.slackmessagebackend.model.domain.User;

import java.util.List;

public interface RoomService {
    List<Room> findRoomsByUser(User user);
}
