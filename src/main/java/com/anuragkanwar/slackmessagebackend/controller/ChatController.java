package com.anuragkanwar.slackmessagebackend.controller;


import com.anuragkanwar.slackmessagebackend.model.dto.request.CreateChatRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.request.DeleteChatRequestDto;
import com.anuragkanwar.slackmessagebackend.service.ChatService;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/chat")
@Slf4j
public class ChatController {

    private final ChatService chatService;
    private final SocketIOServer server;

    public ChatController(ChatService chatService, SocketIOServer server) {
        this.chatService = chatService;
        this.server = server;
    }

    @PostMapping
    public void postMessage(@RequestBody CreateChatRequestDto chat) {

        chatService.saveChat(chat);
        Collection<SocketIOClient> clients =
                server.getRoomOperations(String.valueOf(chat.getRoomId())).getClients();

        for (SocketIOClient socketIOClient : clients) {
            socketIOClient.sendEvent("send_message", chat.getMessage());
        }
    }

    @DeleteMapping
    public void deleteMessage(@RequestBody DeleteChatRequestDto deleteChatRequestDto) {

    }
}