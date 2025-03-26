package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;
import com.corundumstudio.socketio.SocketIOServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Demohandler implements SocketEventHandler {
    @Override
    public void handle(SocketIOServer server, Object data) {

    }

    @Override
    public SocketEvent getEvent() {
        return null;
    }
}
