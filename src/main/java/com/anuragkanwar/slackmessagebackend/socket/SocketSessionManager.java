package com.anuragkanwar.slackmessagebackend.socket;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SocketSessionManager {
    // Key: User ID, Value: Set of Socket.IO session IDs
    private final Map<Long, Set<UUID>> onlineUsers = new ConcurrentHashMap<>();

    public void addSession(Long userId, UUID sessionId) {
        onlineUsers.computeIfAbsent(userId, k -> ConcurrentHashMap.newKeySet()).add(sessionId);
    }

    public Set<UUID> getSessions(Long userId) {
        return onlineUsers.getOrDefault(userId, Collections.emptySet());
    }
}