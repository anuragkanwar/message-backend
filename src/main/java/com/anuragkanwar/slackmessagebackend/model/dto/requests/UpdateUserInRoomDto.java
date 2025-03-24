package com.anuragkanwar.slackmessagebackend.model.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserInRoomDto {
    private Long userId;
    private Long roomId;
}
