package com.anuragkanwar.slackmessagebackend.socket;

//public class SocketEventDispatcher {
//}

import com.anuragkanwar.slackmessagebackend.socket.handlers.SocketEventHandler;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class SocketEventDispatcher {
    private final SocketEventHandlerRegistry registry;
    private final ObjectMapper objectMapper;
    private final SocketIOServer server;

    @Autowired
    public SocketEventDispatcher(SocketEventHandlerRegistry registry,
                                 ObjectMapper objectMapper,
                                 SocketIOServer server) {
        this.registry = registry;
        this.objectMapper = objectMapper;
        this.server = server;
    }

    public void dispatch(SocketEvent event, SocketIOClient client, String rawData) {
        try {
            SocketEventHandler<?, ?> handler = registry.getHandler(event);
            if (handler == null) {
                handleMissingHandler(event, client);
                return;
            }

            Object request = objectMapper.readValue(rawData, handler.getRequestType());
            Object response = handleWithTypeSafety(handler, client, request);

            if (response != null) {
                sendResponse(client, event, response);
            }
        } catch (JsonProcessingException e) {
            handleDeserializationError(event, client, rawData, e);
        } catch (Exception e) {
            handleProcessingError(event, client, e);
        }
    }

    @SuppressWarnings("unchecked")
    private <REQ, RES> RES handleWithTypeSafety(SocketEventHandler<REQ, RES> handler,
                                                SocketIOClient client,
                                                Object request) throws Exception {
        return handler.handle(client, (REQ) request);
    }

    private void sendResponse(SocketIOClient client, SocketEvent event, Object response) {
        String responseEvent = event.name() + "_response";
        client.sendEvent(responseEvent, response);
    }

    private void handleMissingHandler(SocketEvent event, SocketIOClient client) {
        String error = "No handler registered for event: " + event.name();
        client.sendEvent("error", Map.of(
                "event", event.name(),
                "message", error
        ));
        server.getBroadcastOperations().sendEvent("system_alert",
                "Missing handler for event: " + event.name());
    }

    private void handleDeserializationError(SocketEvent event,
                                            SocketIOClient client,
                                            String rawData,
                                            JsonProcessingException e) {
        log.error("Deserialization failed for event {}: {}", event, e.getMessage());
        client.sendEvent("error", Map.of(
                "event", event.name(),
                "message", "Invalid request format",
                "details", e.getOriginalMessage()
        ));
    }

    private void handleProcessingError(SocketEvent event,
                                       SocketIOClient client,
                                       Exception e) {
        log.error("Error processing event {}: {}", event, e.getMessage());
        client.sendEvent("error", Map.of(
                "event", event.name(),
                "message", "Error processing request",
                "details", e.getMessage()
        ));
    }
}
