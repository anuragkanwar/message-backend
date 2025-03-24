package com.anuragkanwar.slackmessagebackend.repository;

import com.anuragkanwar.slackmessagebackend.model.domain.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
    boolean existsWorkspaceByName(String name);
    Workspace getWorkspacesById(Long id);
}
