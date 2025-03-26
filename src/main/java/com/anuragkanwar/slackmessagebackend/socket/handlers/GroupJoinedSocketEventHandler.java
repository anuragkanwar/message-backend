package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.GroupJoinedRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.GroupJoinedResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class GroupJoinedSocketEventHandler implements SocketEventHandler<GroupJoinedRequestDto, GroupJoinedResponseDto> {

    @Override
    public GroupJoinedResponseDto handle(SocketIOClient client, GroupJoinedRequestDto request) {
        // TODO: Implement group_joined event handling
        System.out.println("Handling group_joined event");

        GroupJoinedResponseDto response = new GroupJoinedResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.group_joined;
    }

    @Override
    public Class<GroupJoinedRequestDto> getRequestType() {
        return GroupJoinedRequestDto.class;
    }

    @Override
    public Class<GroupJoinedResponseDto> getResponseType() {
        return GroupJoinedResponseDto.class;
    }
}
