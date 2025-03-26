package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.ReactionAddedRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.ReactionAddedResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class ReactionAddedSocketEventHandler implements SocketEventHandler<ReactionAddedRequestDto, ReactionAddedResponseDto> {

    @Override
    public ReactionAddedResponseDto handle(SocketIOClient client, ReactionAddedRequestDto request) {
        // TODO: Implement reaction_added event handling
        System.out.println("Handling reaction_added event");

        ReactionAddedResponseDto response = new ReactionAddedResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.reaction_added;
    }

    @Override
    public Class<ReactionAddedRequestDto> getRequestType() {
        return ReactionAddedRequestDto.class;
    }

    @Override
    public Class<ReactionAddedResponseDto> getResponseType() {
        return ReactionAddedResponseDto.class;
    }
}
