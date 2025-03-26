package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.ManualPresenceChangeRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.ManualPresenceChangeResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class ManualPresenceChangeSocketEventHandler implements SocketEventHandler<ManualPresenceChangeRequestDto, ManualPresenceChangeResponseDto> {

    @Override
    public ManualPresenceChangeResponseDto handle(SocketIOClient client, ManualPresenceChangeRequestDto request) {
        // TODO: Implement manual_presence_change event handling
        System.out.println("Handling manual_presence_change event");

        ManualPresenceChangeResponseDto response = new ManualPresenceChangeResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.manual_presence_change;
    }

    @Override
    public Class<ManualPresenceChangeRequestDto> getRequestType() {
        return ManualPresenceChangeRequestDto.class;
    }

    @Override
    public Class<ManualPresenceChangeResponseDto> getResponseType() {
        return ManualPresenceChangeResponseDto.class;
    }
}
