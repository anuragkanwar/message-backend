package com.anuragkanwar.slackmessagebackend.service;

import com.anuragkanwar.slackmessagebackend.model.enums.ChatType;
import com.anuragkanwar.slackmessagebackend.model.domain.Chat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.corundumstudio.socketio.SocketIOClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Slf4j
public class SocketService {

    private final ChatService messageService;

    public void sendSocketMessage(SocketIOClient senderClient, Chat message, String room) {

        log.info("inside sendSocketMessage");
        for (SocketIOClient client : senderClient.getNamespace().getRoomOperations(room).getClients()) {
            if (!client.getSessionId().equals(senderClient.getSessionId())) {
                client.sendEvent("read_message", message);
            }
        }
    }

    public void saveMessage(SocketIOClient senderClient, Chat message) {
        log.info("inside saveMessage");
        Chat storedMessage = messageService.saveChat(message);
        sendSocketMessage(senderClient, storedMessage, message.getRoom().getName());
    }

    public void saveInfoMessage(SocketIOClient senderClient, Chat message, String room) {
        log.info("inside saveInfoMessage");
        Chat storedMessage = messageService.saveChat(message);
        sendSocketMessage(senderClient, storedMessage, room);
    }
}