package com.anuragkanwar.slackmessagebackend.model.dto.response;

import com.anuragkanwar.slackmessagebackend.model.domain.Chat;
import com.anuragkanwar.slackmessagebackend.model.enums.ChatType;
import lombok.*;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatDto {

    private Long id;
    private ChatType messageType;
    private String message;
    private int total_replies;
    private boolean is_deleted;
    private ChatDto parent;
    private UserDto user;
    private RoomDto room;


    public static ChatDto toDto(Chat chat) {
        return ChatDto.builder()
                .id(chat.getId())
                .messageType(chat.getMessageType())
                .message(chat.getMessage())
                .total_replies(chat.getTotal_replies())
                .is_deleted(chat.is_deleted())
                .parent(ChatDto.toDtoSmall(chat.getParent()))
                .user(UserDto.ToDtoSmall(chat.getUser()))
                .room(RoomDto.toDtoSmall(chat.getRoom()))
                .build();
    }

    public static ChatDto toDtoSmall(Chat chat) {
        return ChatDto.builder()
                .id(chat.getId())
                .messageType(chat.getMessageType())
                .message(chat.getMessage())
                .total_replies(chat.getTotal_replies())
                .is_deleted(chat.is_deleted())
                .build();
    }

    public static Set<ChatDto> chatSetToChatDtoSet(Set<Chat> chats) {
        return chats.stream().map(ChatDto::toDtoSmall).collect(Collectors.toSet());
    }

}