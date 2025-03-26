package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.ReactionRemovedRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.ReactionRemovedResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class ReactionRemovedSocketEventHandler implements SocketEventHandler<ReactionRemovedRequestDto, ReactionRemovedResponseDto> {

    @Override
    public ReactionRemovedResponseDto handle(SocketIOClient client, ReactionRemovedRequestDto request) {
        // TODO: Implement reaction_removed event handling
        System.out.println("Handling reaction_removed event");

        ReactionRemovedResponseDto response = new ReactionRemovedResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.reaction_removed;
    }

    @Override
    public Class<ReactionRemovedRequestDto> getRequestType() {
        return ReactionRemovedRequestDto.class;
    }

    @Override
    public Class<ReactionRemovedResponseDto> getResponseType() {
        return ReactionRemovedResponseDto.class;
    }
}
