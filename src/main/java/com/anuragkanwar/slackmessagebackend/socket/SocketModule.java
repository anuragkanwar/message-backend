package com.anuragkanwar.slackmessagebackend.socket;

import com.anuragkanwar.slackmessagebackend.configuration.security.service.UserDetailsImpl;
import com.anuragkanwar.slackmessagebackend.constants.Constants;
import com.anuragkanwar.slackmessagebackend.model.domain.Chat;
import com.anuragkanwar.slackmessagebackend.model.domain.Room;
import com.anuragkanwar.slackmessagebackend.model.enums.EventType;
import com.anuragkanwar.slackmessagebackend.service.UserService;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class SocketModule {

    private final UserService userService;
    public final SocketIOServer server;
    public final SocketService socketService;
    private final SocketSessionManager socketSessionManager;

    public SocketModule(
            UserService userService,
            SocketIOServer server,
            SocketService socketService,
            SocketSessionManager socketSessionManager
    ) {
        log.info("Inside SocketModule Constructor");
        this.userService = userService;
        this.server = server;
        this.socketService = socketService;
        this.socketSessionManager = socketSessionManager;
        server.addConnectListener(onConnected());
        server.addDisconnectListener(onDisconnected());
        server.addEventListener(SocketEvent.typing.toString(), Chat.class,
                onUserTyping());
    }


    private DataListener<Chat> onUserTyping() {
        log.info("Inside onUserTyping");
        return (senderClient, data, ackSender) -> {
            log.info(data.toString());
//            socketService.saveMessage(senderClient, data);
        };
    }

    private ConnectListener onConnected() {
        log.info("Inside OnConnected");
        return (client) -> {
            var params =
                    client.getHandshakeData().getUrlParams();
            UserDetailsImpl userDetails = client.get(
                    "user");

            if (log.isDebugEnabled()) {
                log.debug("userDetails : {}", userDetails);
            }

            socketSessionManager.addSession(userDetails.getId(),
                    client.getSessionId());
            List<Room> rooms =
                    userService.findAllRoomsByUserId(userDetails.getId());
            for (Room room : rooms) {
                String username = userDetails.getUsername();
                client.joinRoom(room.getId().toString());
                socketService.saveEventLog(
                        String.format(Constants.WELCOME_MESSAGE, username),
                        room.getId().toString(),
                        EventType.SERVER);
                log.info("Socket ID[{}] - room[{}] - " +
                                "username [{}]  Connected" +
                                " to chat module through",
                        client.getSessionId().toString(),
                        room.getName(),
                        username);
            }
        };
    }

    private DisconnectListener onDisconnected() {
        log.info("Inside OnDisconnected");
        return client -> {
            UserDetailsImpl userDetails = client.get(
                    "user");
            String username = userDetails.getUsername();
            String room = "All";
            socketService.saveEventLog(String.format(Constants.WELCOME_MESSAGE, username), room,
                    EventType.SERVER);
            log.info("Socket ID[{}] - room[{}] - username" +
                            " [{}]  disconnected " +
                            "to chat module through",
                    client.getSessionId().toString(),
                    room, username);
        };
    }

}
