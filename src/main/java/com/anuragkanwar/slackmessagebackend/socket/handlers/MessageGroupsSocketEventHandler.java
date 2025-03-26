package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.MessageGroupsRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.MessageGroupsResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class MessageGroupsSocketEventHandler implements SocketEventHandler<MessageGroupsRequestDto, MessageGroupsResponseDto> {

    @Override
    public MessageGroupsResponseDto handle(SocketIOClient client, MessageGroupsRequestDto request) {
        // TODO: Implement message_groups event handling
        System.out.println("Handling message_groups event");

        MessageGroupsResponseDto response = new MessageGroupsResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.message_groups;
    }

    @Override
    public Class<MessageGroupsRequestDto> getRequestType() {
        return MessageGroupsRequestDto.class;
    }

    @Override
    public Class<MessageGroupsResponseDto> getResponseType() {
        return MessageGroupsResponseDto.class;
    }
}
