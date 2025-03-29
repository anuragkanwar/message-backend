package com.anuragkanwar.slackmessagebackend.socket;

import com.anuragkanwar.slackmessagebackend.socket.handlers.EventHandler;
import com.anuragkanwar.slackmessagebackend.socket.model.BaseEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GenericEventListener {

    private final EventHandlerRegistry registry;

    public GenericEventListener(EventHandlerRegistry registry) {
        this.registry = registry;
    }

    @Async
    @EventListener
    public void handleBaseEvent(BaseEvent event) {
        log.info("got event {}", event.getEventType().name());
        EventHandler<?> handler = registry.getHandler(event.getEventType());
        if (handler != null) {
            // Cast safely using generics
            handleEventWithType(event, handler);
        } else  {
            // Log error: No handler found
            log.info("HANDLER IS NULL #############################");
        }
    }

    // Helper method to handle type casting
    @SuppressWarnings("unchecked")
    private <T extends BaseEvent> void handleEventWithType(T event, EventHandler<?> handler) {
        ((EventHandler<T>) handler).handleEvent(event);
    }
}
