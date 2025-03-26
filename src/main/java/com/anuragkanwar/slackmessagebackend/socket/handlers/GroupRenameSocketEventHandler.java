package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.GroupRenameRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.GroupRenameResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class GroupRenameSocketEventHandler implements SocketEventHandler<GroupRenameRequestDto, GroupRenameResponseDto> {

    @Override
    public GroupRenameResponseDto handle(SocketIOClient client, GroupRenameRequestDto request) {
        // TODO: Implement group_rename event handling
        System.out.println("Handling group_rename event");

        GroupRenameResponseDto response = new GroupRenameResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.group_rename;
    }

    @Override
    public Class<GroupRenameRequestDto> getRequestType() {
        return GroupRenameRequestDto.class;
    }

    @Override
    public Class<GroupRenameResponseDto> getResponseType() {
        return GroupRenameResponseDto.class;
    }
}
