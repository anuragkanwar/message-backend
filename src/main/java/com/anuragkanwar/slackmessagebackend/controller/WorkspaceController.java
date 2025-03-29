package com.anuragkanwar.slackmessagebackend.controller;

import com.anuragkanwar.slackmessagebackend.model.dto.request.CreateWorkspaceRequestDto;
import com.anuragkanwar.slackmessagebackend.model.dto.request.GetWorkspacesByUserIdRequestDto;
import com.anuragkanwar.slackmessagebackend.service.WorkspaceService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@RequestMapping("/api/workspace")
public class WorkspaceController {

    final WorkspaceService workspaceService;

    public WorkspaceController(WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    @GetMapping
    public ResponseEntity<?> getWorkspacesByUserId(@RequestBody GetWorkspacesByUserIdRequestDto requestDto) {
        return ResponseEntity.ok()
                .body(workspaceService.getWorkspacesByUserId(requestDto));
    }

    @GetMapping("/{workspaceId}")
    public ResponseEntity<?> getWorkspacesById(@PathVariable Long workspaceId) {

        ResponseCookie cookie = ResponseCookie.from("workspace-id", workspaceId.toString())
                .httpOnly(false)
                .path("/")
                .maxAge(Duration.ofDays(7))
                .sameSite("Lax")
                .build();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(workspaceService.getWorkspacesById(workspaceId));
    }

    @PostMapping
    public ResponseEntity<?> createWorkspace(@RequestBody CreateWorkspaceRequestDto workspace) {
        return ResponseEntity.ok()
                .body(workspaceService.save(workspace));
    }

    @PatchMapping("/addUsers")
    public ResponseEntity<?> addUserToWorkspace() {
        return ResponseEntity.ok()
                .build();
    }

}
