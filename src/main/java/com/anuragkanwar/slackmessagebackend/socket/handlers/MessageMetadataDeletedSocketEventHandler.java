package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.MessageMetadataDeletedRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.MessageMetadataDeletedResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class MessageMetadataDeletedSocketEventHandler implements SocketEventHandler<MessageMetadataDeletedRequestDto, MessageMetadataDeletedResponseDto> {

    @Override
    public MessageMetadataDeletedResponseDto handle(SocketIOClient client, MessageMetadataDeletedRequestDto request) {
        // TODO: Implement message_metadata_deleted event handling
        System.out.println("Handling message_metadata_deleted event");

        MessageMetadataDeletedResponseDto response = new MessageMetadataDeletedResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.message_metadata_deleted;
    }

    @Override
    public Class<MessageMetadataDeletedRequestDto> getRequestType() {
        return MessageMetadataDeletedRequestDto.class;
    }

    @Override
    public Class<MessageMetadataDeletedResponseDto> getResponseType() {
        return MessageMetadataDeletedResponseDto.class;
    }
}
