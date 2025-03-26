package com.anuragkanwar.slackmessagebackend.socket;

import com.anuragkanwar.slackmessagebackend.socket.handlers.SocketEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SocketEventHandlerRegistry {
    private final Map<SocketEvent, SocketEventHandler<?, ?>> handlers = new ConcurrentHashMap<>();
    private final Map<SocketEvent, Class<?>> requestTypes = new ConcurrentHashMap<>();

    @Autowired
    public SocketEventHandlerRegistry(List<SocketEventHandler<?, ?>> handlerList) {
        handlerList.forEach(handler -> {
            handlers.put(handler.getEventType(), handler);
            requestTypes.put(handler.getEventType(), handler.getRequestType());
        });
    }

    public SocketEventHandler<?, ?> getHandler(SocketEvent event) {
        return handlers.get(event);
    }

    public Class<?> getRequestType(SocketEvent event) {
        return requestTypes.get(event);
    }
}