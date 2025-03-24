package com.anuragkanwar.slackmessagebackend.controller;


import com.anuragkanwar.slackmessagebackend.model.domain.Chat;
import com.anuragkanwar.slackmessagebackend.service.ChatService;
import com.anuragkanwar.slackmessagebackend.socket.SocketModule;
import com.corundumstudio.socketio.SocketIOClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/message")
@RequiredArgsConstructor
@Slf4j
public class ChatController {

    @Autowired
    private final ChatService chatService;

    @Autowired
    private SocketModule socketModule;

    @GetMapping("/{room}")
    public ResponseEntity<List<Chat>> getMessages(@PathVariable String room) {
        log.info("inside getMessages");
        return ResponseEntity.ok(chatService.getChats(Long.getLong(room)));
    }

    @PostMapping
    public void postMessage(@RequestBody Chat chat){

        log.info(String.valueOf(chat));
        chatService.saveChat(chat);
        Collection<SocketIOClient> clients = socketModule.server.getRoomOperations(chat.getRoom().getId().toString()).getClients();

        for (SocketIOClient socketIOClient : clients){
         socketIOClient.sendEvent("send_message", chat.getMessage());
        }
    }
}