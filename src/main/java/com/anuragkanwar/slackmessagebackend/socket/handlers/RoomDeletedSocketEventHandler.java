package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.RoomDeletedRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.RoomDeletedResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class RoomDeletedSocketEventHandler implements SocketEventHandler<RoomDeletedRequestDto, RoomDeletedResponseDto> {

    @Override
    public RoomDeletedResponseDto handle(SocketIOClient client, RoomDeletedRequestDto request) {
        // TODO: Implement room_deleted event handling
        System.out.println("Handling room_deleted event");

        RoomDeletedResponseDto response = new RoomDeletedResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.room_deleted;
    }

    @Override
    public Class<RoomDeletedRequestDto> getRequestType() {
        return RoomDeletedRequestDto.class;
    }

    @Override
    public Class<RoomDeletedResponseDto> getResponseType() {
        return RoomDeletedResponseDto.class;
    }
}
