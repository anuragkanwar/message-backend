package com.anuragkanwar.slackmessagebackend.service.impl;

import com.anuragkanwar.slackmessagebackend.model.domain.Workspace;
import com.anuragkanwar.slackmessagebackend.repository.WorkspaceRepository;
import com.anuragkanwar.slackmessagebackend.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkspaceServiceImpl implements WorkspaceService {

    @Autowired
    private WorkspaceRepository workspaceRepository;


    public Workspace save(Workspace workspace){
        return workspaceRepository.save(workspace);
    }


}
