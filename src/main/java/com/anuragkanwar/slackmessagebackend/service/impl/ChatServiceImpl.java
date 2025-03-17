package com.anuragkanwar.slackmessagebackend.service.impl;

import com.anuragkanwar.slackmessagebackend.model.domain.Chat;
import com.anuragkanwar.slackmessagebackend.repository.ChatRepository;
import com.anuragkanwar.slackmessagebackend.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public List<Chat> getChats(Long roomId) {
        log.info("inside getMessage");
        return chatRepository.findAllByRoom_Id(roomId);
    }

    @Override
    public Chat saveChat(Chat message) {
        log.info("inside saveMessage");
        return chatRepository.save(message);
    }
}