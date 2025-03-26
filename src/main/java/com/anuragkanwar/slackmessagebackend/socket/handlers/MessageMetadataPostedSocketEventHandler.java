package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.MessageMetadataPostedRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.MessageMetadataPostedResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class MessageMetadataPostedSocketEventHandler implements SocketEventHandler<MessageMetadataPostedRequestDto, MessageMetadataPostedResponseDto> {

    @Override
    public MessageMetadataPostedResponseDto handle(SocketIOClient client, MessageMetadataPostedRequestDto request) {
        // TODO: Implement message_metadata_posted event handling
        System.out.println("Handling message_metadata_posted event");

        MessageMetadataPostedResponseDto response = new MessageMetadataPostedResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.message_metadata_posted;
    }

    @Override
    public Class<MessageMetadataPostedRequestDto> getRequestType() {
        return MessageMetadataPostedRequestDto.class;
    }

    @Override
    public Class<MessageMetadataPostedResponseDto> getResponseType() {
        return MessageMetadataPostedResponseDto.class;
    }
}
