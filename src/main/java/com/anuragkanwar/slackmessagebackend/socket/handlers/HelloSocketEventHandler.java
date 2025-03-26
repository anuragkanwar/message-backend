package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.HelloRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.HelloResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class HelloSocketEventHandler implements SocketEventHandler<HelloRequestDto, HelloResponseDto> {

    @Override
    public HelloResponseDto handle(SocketIOClient client, HelloRequestDto request) {
        // TODO: Implement hello event handling
        System.out.println("Handling hello event");

        HelloResponseDto response = new HelloResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.hello;
    }

    @Override
    public Class<HelloRequestDto> getRequestType() {
        return HelloRequestDto.class;
    }

    @Override
    public Class<HelloResponseDto> getResponseType() {
        return HelloResponseDto.class;
    }
}
