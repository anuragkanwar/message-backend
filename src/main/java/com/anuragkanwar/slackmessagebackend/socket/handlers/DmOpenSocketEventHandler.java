package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.DmOpenRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.DmOpenResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class DmOpenSocketEventHandler implements SocketEventHandler<DmOpenRequestDto, DmOpenResponseDto> {

    @Override
    public DmOpenResponseDto handle(SocketIOClient client, DmOpenRequestDto request) {
        // TODO: Implement dm_open event handling
        System.out.println("Handling dm_open event");

        DmOpenResponseDto response = new DmOpenResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.dm_open;
    }

    @Override
    public Class<DmOpenRequestDto> getRequestType() {
        return DmOpenRequestDto.class;
    }

    @Override
    public Class<DmOpenResponseDto> getResponseType() {
        return DmOpenResponseDto.class;
    }
}
