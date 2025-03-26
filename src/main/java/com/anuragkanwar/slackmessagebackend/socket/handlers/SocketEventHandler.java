package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;
import com.corundumstudio.socketio.SocketIOServer;

public interface SocketEventHandler {

    void handle(SocketIOServer server, Object data);
    SocketEvent getEvent();
}

