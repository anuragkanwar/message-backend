package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.MemberLeftRoomRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.MemberLeftRoomResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class MemberLeftRoomSocketEventHandler implements SocketEventHandler<MemberLeftRoomRequestDto, MemberLeftRoomResponseDto> {

    @Override
    public MemberLeftRoomResponseDto handle(SocketIOClient client, MemberLeftRoomRequestDto request) {
        // TODO: Implement member_left_room event handling
        System.out.println("Handling member_left_room event");

        MemberLeftRoomResponseDto response = new MemberLeftRoomResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.member_left_room;
    }

    @Override
    public Class<MemberLeftRoomRequestDto> getRequestType() {
        return MemberLeftRoomRequestDto.class;
    }

    @Override
    public Class<MemberLeftRoomResponseDto> getResponseType() {
        return MemberLeftRoomResponseDto.class;
    }
}
