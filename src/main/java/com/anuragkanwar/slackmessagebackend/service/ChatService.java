package com.anuragkanwar.slackmessagebackend.service;

import com.anuragkanwar.slackmessagebackend.model.domain.Chat;

import java.util.List;

public interface ChatService {
    List<Chat> getChats(Long roomId);
    Chat saveChat(Chat message);
}
