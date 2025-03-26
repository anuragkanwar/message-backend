package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.RoomLeftRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.RoomLeftResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class RoomLeftSocketEventHandler implements SocketEventHandler<RoomLeftRequestDto, RoomLeftResponseDto> {

    @Override
    public RoomLeftResponseDto handle(SocketIOClient client, RoomLeftRequestDto request) {
        // TODO: Implement room_left event handling
        System.out.println("Handling room_left event");

        RoomLeftResponseDto response = new RoomLeftResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.room_left;
    }

    @Override
    public Class<RoomLeftRequestDto> getRequestType() {
        return RoomLeftRequestDto.class;
    }

    @Override
    public Class<RoomLeftResponseDto> getResponseType() {
        return RoomLeftResponseDto.class;
    }
}
