package com.anuragkanwar.slackmessagebackend.controller;

import com.anuragkanwar.slackmessagebackend.model.dto.request.CreateRoomRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.request.UpdateUserInRoomDto;
import com.anuragkanwar.slackmessagebackend.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @PostMapping
    public ResponseEntity<?> createNewRoom(@RequestBody CreateRoomRequestDto requestDto) {
        roomService.save(requestDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<?> getRoomById(@PathVariable Long roomId) {
        return ResponseEntity.ok()
                .body(roomService.getRoomById(roomId));
    }

    @DeleteMapping("/{roomId}")
    public ResponseEntity<?> deleteRoomById(@PathVariable Long roomId) {
        roomService.deleteRoom(roomId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{roomId}")
    public ResponseEntity<?> updateRoom(
            @RequestBody CreateRoomRequestDto requestDto,
            @PathVariable Long roomId
    ) {
        roomService.updateRoom(requestDto, roomId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{roomId}/history")
    public ResponseEntity<?> getRoomWithChatsById(@PathVariable Long roomId) {
        return ResponseEntity.ok()
                .body(roomService.getRoomWithChatsById(roomId));
    }

    @PatchMapping("/{roomId}/user")
    public ResponseEntity<?> addUserToRoom(
            @RequestBody UpdateUserInRoomDto updateUserInRoomDto,
            @PathVariable Long roomId
    ) {
        roomService.addUserToRoom(updateUserInRoomDto.getUserId(), roomId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{roomId}/user")
    public ResponseEntity<?> removeUserFromRoom(
            @RequestBody UpdateUserInRoomDto updateUserInRoomDto,
            @PathVariable Long roomId
    ) {
        roomService.removeUserFromRoom(updateUserInRoomDto.getUserId(), roomId);
        return ResponseEntity.ok().build();
    }


}
