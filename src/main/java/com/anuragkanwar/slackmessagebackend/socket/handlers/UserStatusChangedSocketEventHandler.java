package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.UserStatusChangedRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.UserStatusChangedResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class UserStatusChangedSocketEventHandler implements SocketEventHandler<UserStatusChangedRequestDto, UserStatusChangedResponseDto> {

    @Override
    public UserStatusChangedResponseDto handle(SocketIOClient client, UserStatusChangedRequestDto request) {
        // TODO: Implement user_status_changed event handling
        System.out.println("Handling user_status_changed event");

        UserStatusChangedResponseDto response = new UserStatusChangedResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.user_status_changed;
    }

    @Override
    public Class<UserStatusChangedRequestDto> getRequestType() {
        return UserStatusChangedRequestDto.class;
    }

    @Override
    public Class<UserStatusChangedResponseDto> getResponseType() {
        return UserStatusChangedResponseDto.class;
    }
}
