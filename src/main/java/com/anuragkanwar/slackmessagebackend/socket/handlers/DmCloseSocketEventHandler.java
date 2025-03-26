package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.DmCloseRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.DmCloseResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class DmCloseSocketEventHandler implements SocketEventHandler<DmCloseRequestDto, DmCloseResponseDto> {

    @Override
    public DmCloseResponseDto handle(SocketIOClient client, DmCloseRequestDto request) {
        // TODO: Implement dm_close event handling
        System.out.println("Handling dm_close event");

        DmCloseResponseDto response = new DmCloseResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.dm_close;
    }

    @Override
    public Class<DmCloseRequestDto> getRequestType() {
        return DmCloseRequestDto.class;
    }

    @Override
    public Class<DmCloseResponseDto> getResponseType() {
        return DmCloseResponseDto.class;
    }
}
