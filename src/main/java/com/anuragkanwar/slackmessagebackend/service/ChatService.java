package com.anuragkanwar.slackmessagebackend.service;

import com.anuragkanwar.slackmessagebackend.model.domain.Chat;
import com.anuragkanwar.slackmessagebackend.model.dto.request.CreateChatRequestDto;

import java.util.List;

public interface ChatService {
    List<Chat> getChats(Long roomId);
    Chat saveChat(CreateChatRequestDto message);

    Chat getReferenceById(Long id);
}
