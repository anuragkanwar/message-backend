package com.anuragkanwar.slackmessagebackend.socket;

import com.anuragkanwar.slackmessagebackend.socket.handlers.SocketEventHandler;
import com.corundumstudio.socketio.SocketIOServer;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class SocketEventHandlerRegistry {

    private final List<SocketEventHandler> eventHandlers;
    private final SocketIOServer server;

    private final Map<SocketEvent, SocketEventHandler> eventHandlerMap = new HashMap<>();

    @PostConstruct
    public void registerEventHandlers() {
        for (SocketEventHandler handler : eventHandlers) {
            eventHandlerMap.put(handler.getEvent(), handler);
            server.addEventListener(handler.getEvent().name(), Object.class, (client, data, ackSender) -> {
                handler.handle(client, data[0]);//data is coming as array so we are sending data[0]
            });
            log.info("Registered event handler for: {}", handler.getEvent());
        }
    }

    public SocketEventHandler getHandler(SocketEvent event) {
        return eventHandlerMap.get(event);
    }
}