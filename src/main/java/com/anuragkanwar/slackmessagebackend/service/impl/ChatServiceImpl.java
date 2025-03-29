package com.anuragkanwar.slackmessagebackend.service.impl;

import com.anuragkanwar.slackmessagebackend.model.domain.Chat;
import com.anuragkanwar.slackmessagebackend.model.domain.Room;
import com.anuragkanwar.slackmessagebackend.model.domain.User;
import com.anuragkanwar.slackmessagebackend.model.dto.request.CreateChatRequestDto;
import com.anuragkanwar.slackmessagebackend.repository.ChatRepository;
import com.anuragkanwar.slackmessagebackend.service.ChatService;
import com.anuragkanwar.slackmessagebackend.service.RoomService;
import com.anuragkanwar.slackmessagebackend.service.UserService;
import com.anuragkanwar.slackmessagebackend.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;

    private final UserService userService;

    private final RoomService roomService;


    public ChatServiceImpl(ChatRepository chatRepository, UserService userService,
                           RoomService roomService) {
        this.chatRepository = chatRepository;
        this.userService = userService;
        this.roomService = roomService;
    }

    @Override
    public List<Chat> getChats(Long roomId) {
        log.info("inside getMessage");
        return chatRepository.findAllByRoom_Id(roomId);
    }

    @Transactional
    @Override
    public Chat saveChat(CreateChatRequestDto chatRequestDto) {
        log.info("inside saveMessage");
        Long userId =
                Utils.getCurrentUserIdFromAuthentication(SecurityContextHolder.getContext().getAuthentication());
        User user = userService.getReferenceById(userId);
        Room room = roomService.getReferenceById(chatRequestDto.getRoomId());
        Chat parent = this.getReferenceById(chatRequestDto.getParentId());
        return chatRepository.save(Chat.builder()
                .message(chatRequestDto.getMessage())
                .parent(parent)
                .user(user)
                .room(room)
                .build());
    }


    @Override
    public Chat getReferenceById(Long id) {
        if (id == null)
            return null;
        return chatRepository.getReferenceById(id);
    }
}