package com.anuragkanwar.slackmessagebackend.socket;

@Component
public class SocketEventListener {

    private final EventDispatcher dispatcher;

    @Autowired
    public SocketEventListener(EventDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @OnConnect
    public void onConnect(SocketIOClient client) {
        // Handle connection setup
    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        // Handle cleanup
    }

    @OnEvent("*")
    public void onAnyEvent(SocketIOClient client, AckRequest ack, Object data) {
        String eventName = client.getHandshakeData().getSingleUrlParam("event");
        SocketEvent event = SocketEvent.valueOf(eventName);
        String rawData = objectMapper.writeValueAsString(data);

        dispatcher.dispatch(event, client, rawData);
    }
}
