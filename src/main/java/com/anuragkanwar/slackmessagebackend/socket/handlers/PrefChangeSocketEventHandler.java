package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.PrefChangeRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.PrefChangeResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class PrefChangeSocketEventHandler implements SocketEventHandler<PrefChangeRequestDto, PrefChangeResponseDto> {

    @Override
    public PrefChangeResponseDto handle(SocketIOClient client, PrefChangeRequestDto request) {
        // TODO: Implement pref_change event handling
        System.out.println("Handling pref_change event");

        PrefChangeResponseDto response = new PrefChangeResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.pref_change;
    }

    @Override
    public Class<PrefChangeRequestDto> getRequestType() {
        return PrefChangeRequestDto.class;
    }

    @Override
    public Class<PrefChangeResponseDto> getResponseType() {
        return PrefChangeResponseDto.class;
    }
}
