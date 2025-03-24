package com.anuragkanwar.slackmessagebackend.model.dto;

import com.anuragkanwar.slackmessagebackend.model.domain.Role;
import com.anuragkanwar.slackmessagebackend.model.enums.RoleType;
import lombok.*;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    private Long id;
    private RoleType role;


    public static RoleDto toDto(Role role) {
        return RoleDto.builder().id(role.getId()).role(role.getRole()).build();
    }

    public static RoleDto toDtoSmall(Role role) {
        return toDto(role);
    }

    public static Set<RoleDto> roleSetToRoleDtoSet(Set<Role> roles) {
        return roles.stream().map(RoleDto::toDtoSmall).collect(Collectors.toSet());
    }

}