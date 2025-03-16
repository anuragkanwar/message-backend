package com.anuragkanwar.slackmessagebackend.controller;


import com.anuragkanwar.slackmessagebackend.model.domain.Chat;
import com.anuragkanwar.slackmessagebackend.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
@Slf4j
public class MessageController {

    private final ChatService messageService;

    @CrossOrigin
    @GetMapping("/{room}")
    public ResponseEntity<List<Chat>> getMessages(@PathVariable String room) {
        log.info("inside getMessages");
        return ResponseEntity.ok(messageService.getMessage(room));
    }


}