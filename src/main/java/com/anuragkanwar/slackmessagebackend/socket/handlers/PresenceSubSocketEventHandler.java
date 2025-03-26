package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.PresenceSubRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.PresenceSubResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class PresenceSubSocketEventHandler implements SocketEventHandler<PresenceSubRequestDto, PresenceSubResponseDto> {

    @Override
    public PresenceSubResponseDto handle(SocketIOClient client, PresenceSubRequestDto request) {
        // TODO: Implement presence_sub event handling
        System.out.println("Handling presence_sub event");

        PresenceSubResponseDto response = new PresenceSubResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.presence_sub;
    }

    @Override
    public Class<PresenceSubRequestDto> getRequestType() {
        return PresenceSubRequestDto.class;
    }

    @Override
    public Class<PresenceSubResponseDto> getResponseType() {
        return PresenceSubResponseDto.class;
    }
}
