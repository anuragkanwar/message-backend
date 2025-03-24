package com.anuragkanwar.slackmessagebackend.controller;

import com.anuragkanwar.slackmessagebackend.model.domain.Workspace;
import com.anuragkanwar.slackmessagebackend.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/workspace")
public class WorkspaceController {

    @Autowired
    WorkspaceService workspaceService;

    @GetMapping("/{workspaceId}")
    public ResponseEntity<?> getWorkspacesById(@PathVariable Long workspaceId) {
        return ResponseEntity.ok()
                .body(workspaceService.getWorkspacesById(workspaceId));
    }

    @PostMapping
    public ResponseEntity<?> createWorkspace(@RequestBody Workspace workspace) {
        return
                ResponseEntity.ok()
                    .body(workspaceService.save(workspace));
    }

}
