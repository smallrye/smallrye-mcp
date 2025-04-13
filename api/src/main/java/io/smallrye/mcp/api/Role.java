package io.smallrye.mcp.api;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The sender or recipient of messages in a conversation.
 */
public enum Role {

    ASSISTANT,
    USER;

    @JsonValue
    public String getName() {
        return toString().toLowerCase();
    }

}
