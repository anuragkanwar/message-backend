package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.DmCreatedRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.DmCreatedResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class DmCreatedSocketEventHandler implements SocketEventHandler<DmCreatedRequestDto, DmCreatedResponseDto> {

    @Override
    public DmCreatedResponseDto handle(SocketIOClient client, DmCreatedRequestDto request) {
        // TODO: Implement dm_created event handling
        System.out.println("Handling dm_created event");

        DmCreatedResponseDto response = new DmCreatedResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.dm_created;
    }

    @Override
    public Class<DmCreatedRequestDto> getRequestType() {
        return DmCreatedRequestDto.class;
    }

    @Override
    public Class<DmCreatedResponseDto> getResponseType() {
        return DmCreatedResponseDto.class;
    }
}
