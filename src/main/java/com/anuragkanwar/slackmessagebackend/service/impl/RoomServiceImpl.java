package com.anuragkanwar.slackmessagebackend.service.impl;

import com.anuragkanwar.slackmessagebackend.model.domain.Room;
import com.anuragkanwar.slackmessagebackend.model.domain.User;
import com.anuragkanwar.slackmessagebackend.repository.RoomRepository;
import com.anuragkanwar.slackmessagebackend.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;


    public Room save(Room room) {
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

}
