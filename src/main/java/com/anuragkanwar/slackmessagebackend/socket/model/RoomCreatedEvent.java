package com.anuragkanwar.slackmessagebackend.socket.model;


import com.anuragkanwar.slackmessagebackend.model.dto.common.RoomDto;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;
import lombok.Getter;

@Getter
public class RoomCreatedEvent extends BaseEvent<RoomDto> {
    public RoomCreatedEvent(Object source, SocketEvent eventType, RoomDto data) {
        super(source, eventType, data);
    }
}
