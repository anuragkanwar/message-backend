package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.GroupOpenRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.GroupOpenResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class GroupOpenSocketEventHandler implements SocketEventHandler<GroupOpenRequestDto, GroupOpenResponseDto> {

    @Override
    public GroupOpenResponseDto handle(SocketIOClient client, GroupOpenRequestDto request) {
        // TODO: Implement group_open event handling
        System.out.println("Handling group_open event");

        GroupOpenResponseDto response = new GroupOpenResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.group_open;
    }

    @Override
    public Class<GroupOpenRequestDto> getRequestType() {
        return GroupOpenRequestDto.class;
    }

    @Override
    public Class<GroupOpenResponseDto> getResponseType() {
        return GroupOpenResponseDto.class;
    }
}
