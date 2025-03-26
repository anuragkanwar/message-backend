package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.GoodbyeRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.GoodbyeResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class GoodbyeSocketEventHandler implements SocketEventHandler<GoodbyeRequestDto, GoodbyeResponseDto> {

    @Override
    public GoodbyeResponseDto handle(SocketIOClient client, GoodbyeRequestDto request) {
        // TODO: Implement goodbye event handling
        System.out.println("Handling goodbye event");

        GoodbyeResponseDto response = new GoodbyeResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.goodbye;
    }

    @Override
    public Class<GoodbyeRequestDto> getRequestType() {
        return GoodbyeRequestDto.class;
    }

    @Override
    public Class<GoodbyeResponseDto> getResponseType() {
        return GoodbyeResponseDto.class;
    }
}
