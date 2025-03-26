package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.request.MemberJoinedRoomRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.response.MemberJoinedRoomResponseDto;
import com.corundumstudio.socketio.SocketIOClient;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;

public class MemberJoinedRoomSocketEventHandler implements SocketEventHandler<MemberJoinedRoomRequestDto, MemberJoinedRoomResponseDto> {

    @Override
    public MemberJoinedRoomResponseDto handle(SocketIOClient client, MemberJoinedRoomRequestDto request) {
        // TODO: Implement member_joined_room event handling
        System.out.println("Handling member_joined_room event");

        MemberJoinedRoomResponseDto response = new MemberJoinedRoomResponseDto();
        // Initialize response fields
        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.member_joined_room;
    }

    @Override
    public Class<MemberJoinedRoomRequestDto> getRequestType() {
        return MemberJoinedRoomRequestDto.class;
    }

    @Override
    public Class<MemberJoinedRoomResponseDto> getResponseType() {
        return MemberJoinedRoomResponseDto.class;
    }
}
