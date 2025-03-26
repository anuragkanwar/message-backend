package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.MessageRoomsRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.MessageRoomsResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class MessageRoomsSocketEventHandler implements SocketEventHandler<MessageRoomsRequestDto, MessageRoomsResponseDto> {

    @Override
    public MessageRoomsResponseDto handle(SocketIOClient client, MessageRoomsRequestDto request) {
        // TODO: Implement message_rooms event handling
        System.out.println("Handling message_rooms event");

        MessageRoomsResponseDto response = new MessageRoomsResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.message_rooms;
    }

    @Override
    public Class<MessageRoomsRequestDto> getRequestType() {
        return MessageRoomsRequestDto.class;
    }

    @Override
    public Class<MessageRoomsResponseDto> getResponseType() {
        return MessageRoomsResponseDto.class;
    }
}
