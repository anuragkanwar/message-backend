package com.anuragkanwar.slackmessagebackend.socket.model;

import com.anuragkanwar.slackmessagebackend.socket.SocketEvent;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public abstract class BaseEvent<T> extends ApplicationEvent {
    private final SocketEvent eventType;
    private final T data;

    public BaseEvent(Object source, SocketEvent eventType, T data) {
        super(source);
        this.eventType = eventType;
        this.data = data;
    }

}