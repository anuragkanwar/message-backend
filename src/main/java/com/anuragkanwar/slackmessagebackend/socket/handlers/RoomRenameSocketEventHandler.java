package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.RoomRenameRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.RoomRenameResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class RoomRenameSocketEventHandler implements SocketEventHandler<RoomRenameRequestDto, RoomRenameResponseDto> {

    @Override
    public RoomRenameResponseDto handle(SocketIOClient client, RoomRenameRequestDto request) {
        // TODO: Implement room_rename event handling
        System.out.println("Handling room_rename event");

        RoomRenameResponseDto response = new RoomRenameResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.room_rename;
    }

    @Override
    public Class<RoomRenameRequestDto> getRequestType() {
        return RoomRenameRequestDto.class;
    }

    @Override
    public Class<RoomRenameResponseDto> getResponseType() {
        return RoomRenameResponseDto.class;
    }
}
