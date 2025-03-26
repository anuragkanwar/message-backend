package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.UserTypingRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.UserTypingResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class UserTypingSocketEventHandler implements SocketEventHandler<UserTypingRequestDto, UserTypingResponseDto> {

    @Override
    public UserTypingResponseDto handle(SocketIOClient client, UserTypingRequestDto request) {
        // TODO: Implement user_typing event handling
        System.out.println("Handling user_typing event");

        UserTypingResponseDto response = new UserTypingResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.user_typing;
    }

    @Override
    public Class<UserTypingRequestDto> getRequestType() {
        return UserTypingRequestDto.class;
    }

    @Override
    public Class<UserTypingResponseDto> getResponseType() {
        return UserTypingResponseDto.class;
    }
}
