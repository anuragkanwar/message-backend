package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.RoomCreatedRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.RoomCreatedResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class RoomCreatedSocketEventHandler implements SocketEventHandler<RoomCreatedRequestDto, RoomCreatedResponseDto> {

    @Override
    public RoomCreatedResponseDto handle(SocketIOClient client, RoomCreatedRequestDto request) {
        // TODO: Implement room_created event handling
        System.out.println("Handling room_created event");

        RoomCreatedResponseDto response = new RoomCreatedResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.room_created;
    }

    @Override
    public Class<RoomCreatedRequestDto> getRequestType() {
        return RoomCreatedRequestDto.class;
    }

    @Override
    public Class<RoomCreatedResponseDto> getResponseType() {
        return RoomCreatedResponseDto.class;
    }
}
