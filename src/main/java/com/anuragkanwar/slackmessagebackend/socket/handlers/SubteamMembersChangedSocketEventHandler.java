package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.SubteamMembersChangedRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.SubteamMembersChangedResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class SubteamMembersChangedSocketEventHandler implements SocketEventHandler<SubteamMembersChangedRequestDto, SubteamMembersChangedResponseDto> {

    @Override
    public SubteamMembersChangedResponseDto handle(SocketIOClient client, SubteamMembersChangedRequestDto request) {
        // TODO: Implement subteam_members_changed event handling
        System.out.println("Handling subteam_members_changed event");

        SubteamMembersChangedResponseDto response = new SubteamMembersChangedResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.subteam_members_changed;
    }

    @Override
    public Class<SubteamMembersChangedRequestDto> getRequestType() {
        return SubteamMembersChangedRequestDto.class;
    }

    @Override
    public Class<SubteamMembersChangedResponseDto> getResponseType() {
        return SubteamMembersChangedResponseDto.class;
    }
}
