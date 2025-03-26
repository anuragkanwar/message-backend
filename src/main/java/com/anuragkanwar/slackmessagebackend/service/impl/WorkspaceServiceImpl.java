package com.anuragkanwar.slackmessagebackend.service.impl;

import com.anuragkanwar.slackmessagebackend.model.domain.User;
import com.anuragkanwar.slackmessagebackend.model.domain.Workspace;
import com.anuragkanwar.slackmessagebackend.model.dto.response.WorkspaceDto;
import com.anuragkanwar.slackmessagebackend.repository.WorkspaceRepository;
import com.anuragkanwar.slackmessagebackend.service.UserService;
import com.anuragkanwar.slackmessagebackend.service.WorkspaceService;
import com.anuragkanwar.slackmessagebackend.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class WorkspaceServiceImpl implements WorkspaceService {

    @Autowired
    private WorkspaceRepository workspaceRepository;

    @Autowired
    private UserService userService;


    public WorkspaceDto save(Workspace workspace) {

        String username = Utils.getCurrentUsernameFromAuthentication(SecurityContextHolder.getContext().getAuthentication());
        User user = userService.getUserByUsername(username);
        workspace.setCreator(user);
        workspace.getUsers().add(user);
        return WorkspaceDto.toDto(workspaceRepository.save(workspace));
    }

    @Override
    public WorkspaceDto getWorkspacesById(Long workspaceId) {
        return WorkspaceDto.toDto(workspaceRepository.getWorkspacesById(workspaceId));
    }
}
