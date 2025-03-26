package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.PresenceChangeRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.PresenceChangeResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class PresenceChangeSocketEventHandler implements SocketEventHandler<PresenceChangeRequestDto, PresenceChangeResponseDto> {

    @Override
    public PresenceChangeResponseDto handle(SocketIOClient client, PresenceChangeRequestDto request) {
        // TODO: Implement presence_change event handling
        System.out.println("Handling presence_change event");

        PresenceChangeResponseDto response = new PresenceChangeResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.presence_change;
    }

    @Override
    public Class<PresenceChangeRequestDto> getRequestType() {
        return PresenceChangeRequestDto.class;
    }

    @Override
    public Class<PresenceChangeResponseDto> getResponseType() {
        return PresenceChangeResponseDto.class;
    }
}
