package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.MessageMetadataUpdatedRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.MessageMetadataUpdatedResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class MessageMetadataUpdatedSocketEventHandler implements SocketEventHandler<MessageMetadataUpdatedRequestDto, MessageMetadataUpdatedResponseDto> {

    @Override
    public MessageMetadataUpdatedResponseDto handle(SocketIOClient client, MessageMetadataUpdatedRequestDto request) {
        // TODO: Implement message_metadata_updated event handling
        System.out.println("Handling message_metadata_updated event");

        MessageMetadataUpdatedResponseDto response = new MessageMetadataUpdatedResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.message_metadata_updated;
    }

    @Override
    public Class<MessageMetadataUpdatedRequestDto> getRequestType() {
        return MessageMetadataUpdatedRequestDto.class;
    }

    @Override
    public Class<MessageMetadataUpdatedResponseDto> getResponseType() {
        return MessageMetadataUpdatedResponseDto.class;
    }
}
