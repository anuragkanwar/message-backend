package com.anuragkanwar.slackmessagebackend.socket;

import com.anuragkanwar.slackmessagebackend.model.domain.Chat;
import com.anuragkanwar.slackmessagebackend.model.domain.Event;
import com.anuragkanwar.slackmessagebackend.model.enums.EventType;
import com.anuragkanwar.slackmessagebackend.service.ChatService;
import com.anuragkanwar.slackmessagebackend.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.corundumstudio.socketio.SocketIOClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Slf4j
public class SocketService {

    @Autowired
    private EventService eventService;

    public void saveEventLog( String message, String room, EventType eventType) {
        log.debug("inside saveInfoMessage");
        eventService.save(
                Event.builder()
                        .message(message)
                        .eventType(eventType)
                        .build()
        );
    }
}