package com.anuragkanwar.slackmessagebackend.socket;

import com.anuragkanwar.slackmessagebackend.configuration.security.service.UserDetailsImpl;
import com.anuragkanwar.slackmessagebackend.constants.Constants;
import com.anuragkanwar.slackmessagebackend.model.domain.Room;
import com.anuragkanwar.slackmessagebackend.model.enums.EventType;
import com.anuragkanwar.slackmessagebackend.service.UserService;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class SocketEventListener {
    private final SocketEventDispatcher dispatcher;
    private final ObjectMapper objectMapper;
    private final UserService userService;
    private final SocketService socketService;

    @Autowired
    public SocketEventListener(SocketEventDispatcher dispatcher, ObjectMapper objectMapper, UserService userService, SocketService socketService) {
        this.dispatcher = dispatcher;
        this.objectMapper = objectMapper;
        this.userService = userService;
        this.socketService = socketService;
    }

    @OnEvent("*")
    public void onAnyEvent(SocketIOClient client, AckRequest ack, Object data) {
        try {
            String eventName = client.getHandshakeData().getSingleUrlParam("event");
            SocketEvent event = SocketEvent.valueOf(eventName);

            // Convert data to raw JSON string
            String rawData = convertDataToString(data);

            dispatcher.dispatch(event, client, rawData);
        } catch (IllegalArgumentException e) {
            handleUnknownEvent(client, e);
        } catch (Exception e) {
            handleGenericError(client, e);
        }
    }

    @OnConnect
    public void onConnect(SocketIOClient client) {
        // Handle connection setup
        var params = client.getHandshakeData().getUrlParams();
        UserDetailsImpl userDetails = client.get("user");
        System.out.println(userDetails);
        List<Room> rooms = userService.findAllRoomsByUserId(userDetails.getId());

        for (Room room : rooms) {
            String username = userDetails.getUsername();
            client.joinRoom(room.getId().toString());
            socketService.saveEventLog(String.format(Constants.WELCOME_MESSAGE, username), room.getId().toString(), EventType.SERVER);
            log.info("Socket ID[{}] - room[{}] - username [{}]  Connected to chat module through", client.getSessionId().toString(), room.getName(), username);
        }

    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        // Handle cleanup
        UserDetailsImpl userDetails = client.get("user");
        String username = userDetails.getUsername();
        String room = "All";
        socketService.saveEventLog(String.format(Constants.WELCOME_MESSAGE, username), room, EventType.SERVER);
        log.info("Socket ID[{}] - room[{}] - username [{}]  disconnected to chat module through", client.getSessionId().toString(), room, username);

    }

    private String convertDataToString(Object data) throws JsonProcessingException {
        if (data instanceof String) {
            return (String) data;
        }
        return objectMapper.writeValueAsString(data);
    }

    private void handleUnknownEvent(SocketIOClient client, Exception e) {
        log.error("Unknown event type received", e);
        client.sendEvent("error", Map.of(
                "message", "Unknown event type",
                "details", e.getMessage()
        ));
    }

    private void handleGenericError(SocketIOClient client, Exception e) {
        log.error("Error processing event", e);
        client.sendEvent("error", Map.of(
                "message", "Error processing request",
                "details", e.getMessage()
        ));
    }
}


/*

sequenceDiagram
    participant Client
    participant SocketIO
    participant EventListener
    participant Dispatcher
    participant Handler

    Client->>SocketIO: Send event with data
    SocketIO->>EventListener: Forward event
    EventListener->>EventListener: Convert data to JSON string
    EventListener->>Dispatcher: Dispatch event + raw JSON
    Dispatcher->>Handler: Route to appropriate handler
    Handler->>Dispatcher: Return response
    Dispatcher->>Client: Send response/error

 */