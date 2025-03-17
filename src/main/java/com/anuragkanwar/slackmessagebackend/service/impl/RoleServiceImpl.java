package com.anuragkanwar.slackmessagebackend.service.impl;

import com.anuragkanwar.slackmessagebackend.model.domain.Role;
import com.anuragkanwar.slackmessagebackend.model.enums.RoleType;
import com.anuragkanwar.slackmessagebackend.repository.RoleRepository;
import com.anuragkanwar.slackmessagebackend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getRoleByRole(RoleType roleType) {
        return roleRepository.getRoleByRole(roleType);
    }

    @Override
    public boolean existsRoleByRole(RoleType roleType) {
        return roleRepository.existsRoleByRole(roleType);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
