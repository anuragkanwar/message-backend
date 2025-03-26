package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.GroupDeletedRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.GroupDeletedResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class GroupDeletedSocketEventHandler implements SocketEventHandler<GroupDeletedRequestDto, GroupDeletedResponseDto> {

    @Override
    public GroupDeletedResponseDto handle(SocketIOClient client, GroupDeletedRequestDto request) {
        // TODO: Implement group_deleted event handling
        System.out.println("Handling group_deleted event");

        GroupDeletedResponseDto response = new GroupDeletedResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.group_deleted;
    }

    @Override
    public Class<GroupDeletedRequestDto> getRequestType() {
        return GroupDeletedRequestDto.class;
    }

    @Override
    public Class<GroupDeletedResponseDto> getResponseType() {
        return GroupDeletedResponseDto.class;
    }
}
