package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.SubteamSelfRemovedRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.SubteamSelfRemovedResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class SubteamSelfRemovedSocketEventHandler implements SocketEventHandler<SubteamSelfRemovedRequestDto, SubteamSelfRemovedResponseDto> {

    @Override
    public SubteamSelfRemovedResponseDto handle(SocketIOClient client, SubteamSelfRemovedRequestDto request) {
        // TODO: Implement subteam_self_removed event handling
        System.out.println("Handling subteam_self_removed event");

        SubteamSelfRemovedResponseDto response = new SubteamSelfRemovedResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.subteam_self_removed;
    }

    @Override
    public Class<SubteamSelfRemovedRequestDto> getRequestType() {
        return SubteamSelfRemovedRequestDto.class;
    }

    @Override
    public Class<SubteamSelfRemovedResponseDto> getResponseType() {
        return SubteamSelfRemovedResponseDto.class;
    }
}
