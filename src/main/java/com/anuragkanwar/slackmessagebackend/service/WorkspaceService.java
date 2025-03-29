package com.anuragkanwar.slackmessagebackend.service;

import com.anuragkanwar.slackmessagebackend.model.domain.Workspace;
import com.anuragkanwar.slackmessagebackend.model.dto.common.WorkspaceDto;
import com.anuragkanwar.slackmessagebackend.model.dto.request.CreateWorkspaceRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.request.GetWorkspacesByUserIdRequestDto;

import java.util.Set;


public interface WorkspaceService {
    WorkspaceDto save(CreateWorkspaceRequestDto workspace);

    Set<WorkspaceDto> getWorkspacesByUserId(GetWorkspacesByUserIdRequestDto requestDto);

    WorkspaceDto getWorkspacesById(Long workspaceId);

    Workspace getReferenceById(Long id);
}