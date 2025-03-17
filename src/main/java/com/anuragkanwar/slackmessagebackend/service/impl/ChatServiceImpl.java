package com.anuragkanwar.slackmessagebackend.service.impl;

import com.anuragkanwar.slackmessagebackend.configuration.security.service.UserDetailsImpl;
import com.anuragkanwar.slackmessagebackend.model.domain.Chat;
import com.anuragkanwar.slackmessagebackend.model.domain.Room;
import com.anuragkanwar.slackmessagebackend.model.domain.User;
import com.anuragkanwar.slackmessagebackend.repository.ChatRepository;
import com.anuragkanwar.slackmessagebackend.service.ChatService;
import com.anuragkanwar.slackmessagebackend.service.RoomService;
import com.anuragkanwar.slackmessagebackend.service.UserService;
import com.anuragkanwar.slackmessagebackend.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;

    @Override
    public List<Chat> getChats(Long roomId) {
        log.info("inside getMessage");
        return chatRepository.findAllByRoom_Id(roomId);
    }

    @Override
    public Chat saveChat(Chat message) {
        log.info("inside saveMessage");
        String username = Utils.getCurrentUsernameFromAuthentication(SecurityContextHolder.getContext().getAuthentication());
        User user = userService.getUserByUsername(username);
        Room room = roomService.getRoomById(message.getRoom().getId());
        message.setUser(user);
        message.setRoom(room);
        return chatRepository.save(message);
    }




}