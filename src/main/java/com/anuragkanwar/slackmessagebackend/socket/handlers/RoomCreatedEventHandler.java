package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.model.dto.common.RoomDto;
import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;
import com.anuragkanwar.slackmessagebackend.socket.model.BaseEvent;
import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.stereotype.Component;

@Component
public class RoomCreatedEventHandler implements EventHandler<RoomDto> {

    private final SocketIOServer socketServer;

    public RoomCreatedEventHandler(SocketIOServer socketServer) {
        this.socketServer = socketServer;
    }

    @Override
    public void handleEvent(BaseEvent<RoomDto> event) {
        RoomDto roomDto = event.getData();
        socketServer.getRoomOperations(roomDto.getId().toString())
                .sendEvent(SocketEvent.room_created.toString(), roomDto);
    }

    @Override
    public SocketEvent getSupportedEventType() {
        return SocketEvent.room_created;
    }
}
