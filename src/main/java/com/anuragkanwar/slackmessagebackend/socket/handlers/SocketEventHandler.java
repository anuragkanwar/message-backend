package com.anuragkanwar.slackmessagebackend.socket.handlers;

import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;
import com.corundumstudio.socketio.SocketIOClient;

public interface SocketEventHandler<REQUEST, RESPONSE> {
    RESPONSE handle(SocketIOClient client, REQUEST request);
    SocketEvent getEventType();
    Class<REQUEST> getRequestType();
    Class<RESPONSE> getResponseType();
}