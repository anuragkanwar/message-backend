package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.UserProfileChangedRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.UserProfileChangedResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class UserProfileChangedSocketEventHandler implements SocketEventHandler<UserProfileChangedRequestDto, UserProfileChangedResponseDto> {

    @Override
    public UserProfileChangedResponseDto handle(SocketIOClient client, UserProfileChangedRequestDto request) {
        // TODO: Implement user_profile_changed event handling
        System.out.println("Handling user_profile_changed event");

        UserProfileChangedResponseDto response = new UserProfileChangedResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.user_profile_changed;
    }

    @Override
    public Class<UserProfileChangedRequestDto> getRequestType() {
        return UserProfileChangedRequestDto.class;
    }

    @Override
    public Class<UserProfileChangedResponseDto> getResponseType() {
        return UserProfileChangedResponseDto.class;
    }
}
