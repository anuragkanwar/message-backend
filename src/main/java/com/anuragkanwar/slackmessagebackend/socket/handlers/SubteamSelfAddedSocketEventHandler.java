package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.SubteamSelfAddedRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.SubteamSelfAddedResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class SubteamSelfAddedSocketEventHandler implements SocketEventHandler<SubteamSelfAddedRequestDto, SubteamSelfAddedResponseDto> {

    @Override
    public SubteamSelfAddedResponseDto handle(SocketIOClient client, SubteamSelfAddedRequestDto request) {
        // TODO: Implement subteam_self_added event handling
        System.out.println("Handling subteam_self_added event");

        SubteamSelfAddedResponseDto response = new SubteamSelfAddedResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.subteam_self_added;
    }

    @Override
    public Class<SubteamSelfAddedRequestDto> getRequestType() {
        return SubteamSelfAddedRequestDto.class;
    }

    @Override
    public Class<SubteamSelfAddedResponseDto> getResponseType() {
        return SubteamSelfAddedResponseDto.class;
    }
}
