package com.anuragkanwar.slackmessagebackend.service;

import com.anuragkanwar.slackmessagebackend.model.domain.Chat;
import com.anuragkanwar.slackmessagebackend.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ChatService {

    private final ChatRepository chatRepository;

    public List<Chat> getChats(Long roomId) {
        log.info("inside getMessage");
        return chatRepository.findAllByRoom_Id(roomId);
    }

    public Chat saveChat(Chat message) {
        log.info("inside saveMessage");
        return chatRepository.save(message);
    }
}