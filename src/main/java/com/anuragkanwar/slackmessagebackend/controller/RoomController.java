package com.anuragkanwar.slackmessagebackend.controller;

import com.anuragkanwar.slackmessagebackend.model.domain.Room;
import com.anuragkanwar.slackmessagebackend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/")
    public Room createNewRoom(Room room){
        return roomService.save(room);
    }
}
