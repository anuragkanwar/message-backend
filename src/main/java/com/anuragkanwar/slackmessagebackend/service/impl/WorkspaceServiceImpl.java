package com.anuragkanwar.slackmessagebackend.service.impl;

import com.anuragkanwar.slackmessagebackend.model.domain.User;
import com.anuragkanwar.slackmessagebackend.model.domain.Workspace;
import com.anuragkanwar.slackmessagebackend.model.dto.common.WorkspaceDto;
import com.anuragkanwar.slackmessagebackend.model.dto.request.CreateWorkspaceRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.request.GetWorkspacesByUserIdRequestDto;
import com.anuragkanwar.slackmessagebackend.repository.WorkspaceRepository;
import com.anuragkanwar.slackmessagebackend.service.UserService;
import com.anuragkanwar.slackmessagebackend.service.WorkspaceService;
import com.anuragkanwar.slackmessagebackend.utils.Utils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class WorkspaceServiceImpl implements WorkspaceService {

    private final WorkspaceRepository workspaceRepository;
    private final UserService userService;

    public WorkspaceServiceImpl(WorkspaceRepository workspaceRepository, UserService userService) {
        this.workspaceRepository = workspaceRepository;
        this.userService = userService;
    }


    public WorkspaceDto save(CreateWorkspaceRequestDto workspace) {

        Long creatorId =
                Utils.getCurrentUserIdFromAuthentication(
                        SecurityContextHolder.getContext().getAuthentication());

        User creator = userService.getReferenceById(creatorId);
        Set<User> users = new HashSet<>(List.of(creator));

        return WorkspaceDto.toDto(
                Workspace.builder()
                        .name(workspace.getName())
                        .creator(creator)
                        .users(users)
                        .build()
        );
    }

    @Override
    public Set<WorkspaceDto> getWorkspacesByUserId(GetWorkspacesByUserIdRequestDto requestDto) {
        return WorkspaceDto.workspaceSetToWorkspaceDtoSet(
                workspaceRepository.getWorkspacesByCreator_Id(requestDto.getUserId()));
    }

    @Override
    public WorkspaceDto getWorkspacesById(Long workspaceId) {
        return WorkspaceDto.toDto(workspaceRepository.getWorkspacesById(workspaceId));
    }

    @Override
    public Workspace getReferenceById(Long id) {
        if (id == null)
            return null;
        return workspaceRepository.getReferenceById(id);
    }
}
