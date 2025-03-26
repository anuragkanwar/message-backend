package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.MessageDmRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.MessageDmResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class MessageDmSocketEventHandler implements SocketEventHandler<MessageDmRequestDto, MessageDmResponseDto> {

    @Override
    public MessageDmResponseDto handle(SocketIOClient client, MessageDmRequestDto request) {
        // TODO: Implement message_dm event handling
        System.out.println("Handling message_dm event");

        MessageDmResponseDto response = new MessageDmResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.message_dm;
    }

    @Override
    public Class<MessageDmRequestDto> getRequestType() {
        return MessageDmRequestDto.class;
    }

    @Override
    public Class<MessageDmResponseDto> getResponseType() {
        return MessageDmResponseDto.class;
    }
}
