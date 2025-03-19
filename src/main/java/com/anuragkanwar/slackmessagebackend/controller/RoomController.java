package com.anuragkanwar.slackmessagebackend.controller;

import com.anuragkanwar.slackmessagebackend.model.domain.Room;
import com.anuragkanwar.slackmessagebackend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public Room createNewRoom(Room room){
        return roomService.save(room);
    }

    @DeleteMapping
    public void deleteRoomById(Long id){
        return roomService
    }

    @PatchMapping("/user")
    public Room addUserToRoom(@RequestBody Long userId, @RequestBody Long roomId){
        return roomService.addUserToRoom(userId, roomId);
    }

    @DeleteMapping("/user")
    public Room removeUserFromRoom(@RequestBody Long userId, @RequestBody Long roomId){
        return roomService.removeUserFromRoom(userId, roomId);
    }
}
