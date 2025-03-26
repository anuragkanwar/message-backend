package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.PresenceQueryRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.PresenceQueryResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class PresenceQuerySocketEventHandler implements SocketEventHandler<PresenceQueryRequestDto, PresenceQueryResponseDto> {

    @Override
    public PresenceQueryResponseDto handle(SocketIOClient client, PresenceQueryRequestDto request) {
        // TODO: Implement presence_query event handling
        System.out.println("Handling presence_query event");

        PresenceQueryResponseDto response = new PresenceQueryResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.presence_query;
    }

    @Override
    public Class<PresenceQueryRequestDto> getRequestType() {
        return PresenceQueryRequestDto.class;
    }

    @Override
    public Class<PresenceQueryResponseDto> getResponseType() {
        return PresenceQueryResponseDto.class;
    }
}
