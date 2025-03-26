package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.RoomJoinedRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.RoomJoinedResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class RoomJoinedSocketEventHandler implements SocketEventHandler<RoomJoinedRequestDto, RoomJoinedResponseDto> {

    @Override
    public RoomJoinedResponseDto handle(SocketIOClient client, RoomJoinedRequestDto request) {
        // TODO: Implement room_joined event handling
        System.out.println("Handling room_joined event");

        RoomJoinedResponseDto response = new RoomJoinedResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.room_joined;
    }

    @Override
    public Class<RoomJoinedRequestDto> getRequestType() {
        return RoomJoinedRequestDto.class;
    }

    @Override
    public Class<RoomJoinedResponseDto> getResponseType() {
        return RoomJoinedResponseDto.class;
    }
}
