#!/bin/bash

# Configuration
PACKAGE="/home/anumax/projects/slackmessagebackend/src/main/java/com/anuragkanwar/slackmessagebackend/socket/handlers"
REQUEST_DTO_PACKAGE="/home/anumax/projects/slackmessagebackend/src/main/java/com/anuragkanwar/slackmessagebackend/model/dto/request"
RESPONSE_DTO_PACKAGE="/home/anumax/projects/slackmessagebackend/src/main/java/com/anuragkanwar/slackmessagebackend/model/dto/response"
OUTPUT_DIR="src/main/java/com/yourpackage/socket"

# Create directories if they don't exist
#mkdir -p "$OUTPUT_DIR/handlers"
#mkdir -p "$OUTPUT_DIR/dtos/request"
#mkdir -p "$OUTPUT_DIR/dtos/response"

declare -a ENUM_VALUES=(
    # ... (your existing enum values array remains the same)
        "dm_close"
        "dm_created"
        "dm_open"
        "goodbye"
        "group_deleted"
        "group_joined"
        "group_left"
        "group_open"
        "group_rename"
        "hello"
        "manual_presence_change"
        "member_joined_room"
        "member_left_room"
        "message_dm"
        "message_groups"
        "message_metadata_deleted"
        "message_metadata_posted"
        "message_metadata_updated"
        "message_rooms"
        "pref_change"
        "presence_change"
        "presence_query"
        "presence_sub"
        "reaction_added"
        "reaction_removed"
        "room_created"
        "room_deleted"
        "room_joined"
        "room_left"
        "room_rename"
        "subteam_members_changed"
        "subteam_self_added"
        "subteam_self_removed"
        "subteam_updated"
        "user_change"
        "user_profile_changed"
        "user_status_changed"
        "user_typing"
)

# Generate handler and DTO classes for each enum value
for event_name in "${ENUM_VALUES[@]}"; do
  # Convert naming conventions
  CLASS_NAME=$(echo "$event_name" | awk -F_ '{for(i=1;i<=NF;i++) $i=toupper(substr($i,1,1)) substr($i,2)}1' | tr -d '_')
  HANDLER_NAME="${CLASS_NAME}Handler"
  REQUEST_DTO_NAME="${CLASS_NAME}RequestDto"
  RESPONSE_DTO_NAME="${CLASS_NAME}ResponseDto"

  # Generate Handler Class
  cat > "$OUTPUT_DIR/handlers/$HANDLER_NAME.java" <<EOF
package $PACKAGE;

import $REQUEST_DTO_PACKAGE.$REQUEST_DTO_NAME;
import $RESPONSE_DTO_PACKAGE.$RESPONSE_DTO_NAME;
import com.corundumstudio.socketio.SocketIOClient;
import com.yourpackage.socket.SocketEvent;
import com.yourpackage.socket.SocketEventHandler;

public class $HANDLER_NAME implements SocketEventHandler<$REQUEST_DTO_NAME, $RESPONSE_DTO_NAME> {

    @Override
    public $RESPONSE_DTO_NAME handle(SocketIOClient client, $REQUEST_DTO_NAME request) {
        // TODO: Implement $event_name event handling
        System.out.println("Handling $event_name event");

        // Process request and create response
        $RESPONSE_DTO_NAME response = new $RESPONSE_DTO_NAME();
        // response.setSomeField(processRequest(request));

        return response;
    }

    @Override
    public SocketEvent getEventType() {
        return SocketEvent.$event_name;
    }

    @Override
    public Class<$REQUEST_DTO_NAME> getRequestType() {
        return $REQUEST_DTO_NAME.class;
    }

    @Override
    public Class<$RESPONSE_DTO_NAME> getResponseType() {
        return $RESPONSE_DTO_NAME.class;
    }
}
EOF

  # Generate Request DTO
  cat > "$OUTPUT_DIR/dtos/request/$REQUEST_DTO_NAME.java" <<EOF
package $REQUEST_DTO_PACKAGE;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class $REQUEST_DTO_NAME {
    // TODO: Add request fields for $event_name event

    // Example fields:
    // private String userId;
    // private String message;

    // Generate getters and setters below
}
EOF

  # Generate Response DTO
  cat > "$OUTPUT_DIR/dtos/response/$RESPONSE_DTO_NAME.java" <<EOF
package $RESPONSE_DTO_PACKAGE;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class $RESPONSE_DTO_NAME {
    // TODO: Add response fields for $event_name event

    // Example fields:
    // private boolean success;
    // private String status;
    // private String timestamp;

    // Generate getters and setters below
}
EOF

  echo "Generated $HANDLER_NAME with $REQUEST_DTO_NAME and $RESPONSE_DTO_NAME"
done

echo "Generation complete! Created ${#ENUM_VALUES[@]} handlers with request/response DTO pairs."