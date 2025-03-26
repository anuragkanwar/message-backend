package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.GroupLeftRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.GroupLeftResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class GroupLeftSocketEventHandler implements SocketEventHandler<GroupLeftRequestDto, GroupLeftResponseDto> {

    @Override
    public GroupLeftResponseDto handle(SocketIOClient client, GroupLeftRequestDto request) {
        // TODO: Implement group_left event handling
        System.out.println("Handling group_left event");

        GroupLeftResponseDto response = new GroupLeftResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.group_left;
    }

    @Override
    public Class<GroupLeftRequestDto> getRequestType() {
        return GroupLeftRequestDto.class;
    }

    @Override
    public Class<GroupLeftResponseDto> getResponseType() {
        return GroupLeftResponseDto.class;
    }
}
