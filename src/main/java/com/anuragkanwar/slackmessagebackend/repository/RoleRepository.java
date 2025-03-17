package com.anuragkanwar.slackmessagebackend.repository;

import com.anuragkanwar.slackmessagebackend.model.domain.Role;
import com.anuragkanwar.slackmessagebackend.model.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    boolean existsRoleByRole(RoleType role);

    Role getRoleByRole(RoleType role);

    RoleType role(RoleType role);
}
