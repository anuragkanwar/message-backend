package com.anuragkanwar.slackmessagebackend.service;

import com.anuragkanwar.slackmessagebackend.model.domain.Workspace;
import com.anuragkanwar.slackmessagebackend.model.dto.WorkspaceDto;


public interface WorkspaceService {
    WorkspaceDto save(Workspace workspace);
    WorkspaceDto getWorkspacesById(Long workspaceId);
}