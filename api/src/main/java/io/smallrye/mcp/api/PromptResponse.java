package io.smallrye.mcp.api;

import java.util.List;

/**
 * Response to a {@code prompts/get} request from the client.
 *
 * @param description an optional description for the prompt
 * @param messages the prompt messages (must not be {@code null})
 */
public record PromptResponse(String description, List<PromptMessage> messages) {

    /**
     * Creates a new response with the given messages.
     *
     * @param messages the prompt messages (must not be {@code null})
     * @return a new response
     */
    public static PromptResponse withMessages(List<PromptMessage> messages) {
        return new PromptResponse(null, messages);
    }

    /**
     * Creates a new response with the given description and messages.
     *
     * @param description an optional description for the prompt
     * @param messages the prompt messages (must not be {@code null})
     */
    public PromptResponse {
        if (messages == null) {
            throw new IllegalArgumentException("messages must not be null");
        }
    }

}
