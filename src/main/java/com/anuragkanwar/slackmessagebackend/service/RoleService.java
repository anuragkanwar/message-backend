package com.anuragkanwar.slackmessagebackend.service;

import com.anuragkanwar.slackmessagebackend.model.domain.Role;
import com.anuragkanwar.slackmessagebackend.model.enums.RoleType;

public interface RoleService {
    Role getRoleByRole(RoleType roleType);

    boolean existsRoleByRole(RoleType roleType);

    Role save(Role build);
}
