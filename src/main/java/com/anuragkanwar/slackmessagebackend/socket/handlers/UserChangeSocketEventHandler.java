package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.UserChangeRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.UserChangeResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class UserChangeSocketEventHandler implements SocketEventHandler<UserChangeRequestDto, UserChangeResponseDto> {

    @Override
    public UserChangeResponseDto handle(SocketIOClient client, UserChangeRequestDto request) {
        // TODO: Implement user_change event handling
        System.out.println("Handling user_change event");

        UserChangeResponseDto response = new UserChangeResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.user_change;
    }

    @Override
    public Class<UserChangeRequestDto> getRequestType() {
        return UserChangeRequestDto.class;
    }

    @Override
    public Class<UserChangeResponseDto> getResponseType() {
        return UserChangeResponseDto.class;
    }
}
