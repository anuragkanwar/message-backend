package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.SubteamUpdatedRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.SubteamUpdatedResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class SubteamUpdatedSocketEventHandler implements SocketEventHandler<SubteamUpdatedRequestDto, SubteamUpdatedResponseDto> {

    @Override
    public SubteamUpdatedResponseDto handle(SocketIOClient client, SubteamUpdatedRequestDto request) {
        // TODO: Implement subteam_updated event handling
        System.out.println("Handling subteam_updated event");

        SubteamUpdatedResponseDto response = new SubteamUpdatedResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.subteam_updated;
    }

    @Override
    public Class<SubteamUpdatedRequestDto> getRequestType() {
        return SubteamUpdatedRequestDto.class;
    }

    @Override
    public Class<SubteamUpdatedResponseDto> getResponseType() {
        return SubteamUpdatedResponseDto.class;
    }
}
