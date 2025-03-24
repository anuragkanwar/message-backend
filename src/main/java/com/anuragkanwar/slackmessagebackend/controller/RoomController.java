package com.anuragkanwar.slackmessagebackend.controller;

import com.anuragkanwar.slackmessagebackend.model.domain.Room;
import com.anuragkanwar.slackmessagebackend.model.dto.RoomDto;
import com.anuragkanwar.slackmessagebackend.model.dto.requests.UpdateUserInRoomDto;
import com.anuragkanwar.slackmessagebackend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;


    @PostMapping
    public ResponseEntity<?> createNewRoom(@RequestBody Room room) {
        return ResponseEntity.ok().body(RoomDto.toDto(roomService.save(room)));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteRoomById(@RequestBody Long id) {
        return ResponseEntity.ok().body(RoomDto.toDto(roomService.deleteRoom(id)));
    }

    @PatchMapping("/user")
    public ResponseEntity<?> addUserToRoom(@RequestBody UpdateUserInRoomDto updateUserInRoomDto) {
        return ResponseEntity.ok().body(RoomDto.toDto(roomService.addUserToRoom(updateUserInRoomDto.getUserId(), updateUserInRoomDto.getRoomId())));
    }

    @DeleteMapping("/user")
    public ResponseEntity<?> removeUserFromRoom(@RequestBody UpdateUserInRoomDto updateUserInRoomDto) {
        return ResponseEntity.ok().body(RoomDto.toDto(roomService.removeUserFromRoom(updateUserInRoomDto.getUserId(), updateUserInRoomDto.getRoomId()

        )));
    }
}
