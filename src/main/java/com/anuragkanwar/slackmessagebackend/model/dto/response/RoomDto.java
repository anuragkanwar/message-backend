package com.anuragkanwar.slackmessagebackend.model.dto.response;

import com.anuragkanwar.slackmessagebackend.model.domain.Room;
import lombok.*;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {

    private Long id;
    private String name;
    private String description;
    private boolean is_private;
    private WorkspaceDto workspace;
    private Set<UserDto> users;
    private UserDto creator;


    public static RoomDto toDto(Room room) {
        return RoomDto.builder()
                .id(room.getId())
                .name(room.getName())
                .description(room.getDescription())
                .is_private(room.is_private())
                .workspace(WorkspaceDto.toDtoSmall(room.getWorkspace()))
                .users(UserDto.userSetToUserDtoSet(room.getUsers()))
                .creator(UserDto.ToDtoSmall(room.getCreator()))
                .build();
    }


    public static RoomDto toDtoSmall(Room room) {
        return RoomDto.builder()
                .id(room.getId())
                .name(room.getName())
                .description(room.getDescription())
                .is_private(room.is_private())
                .creator(UserDto.ToDtoSmall(room.getCreator()))
                .build();
    }

    public static Set<RoomDto> roomSetToRoomDtoSet(Set<Room> rooms) {
        return rooms.stream().map(RoomDto::toDtoSmall).collect(Collectors.toSet());
    }


}