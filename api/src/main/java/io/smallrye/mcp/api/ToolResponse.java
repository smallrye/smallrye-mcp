package io.smallrye.mcp.api;

import java.util.Arrays;
import java.util.List;

/**
 * Response to a {@code tools/list} request from the client.
 *
 * @param isError {@code true} if the tool call ended in an error
 * @param content the list of content items (must not be {@code null})
 */
public record ToolResponse(boolean isError, List<? extends Content> content) {

    /**
     * Creates a new response with the given content items.
     *
     * @param <C> the type of content
     * @param content the content items (must not be {@code null})
     * @return a successful response with the specified content items
     */
    @SafeVarargs
    public static <C extends Content> ToolResponse success(C... content) {
        return new ToolResponse(false, Arrays.asList(content));
    }

    /**
     * Creates a new response with the given content items.
     *
     * @param <C> the type of content
     * @param content the content items (must not be {@code null})
     * @return a successful response with the specified content items
     */
    public static <C extends Content> ToolResponse success(List<C> content) {
        return new ToolResponse(false, content);
    }

    /**
     * Creates a new response with the given content items.
     *
     * @param message the message to be included in the response
     * @return an unsuccessful response with single text content item
     */
    public static ToolResponse error(String message) {
        return new ToolResponse(true, List.of(new TextContent(message)));
    }

    /**
     * Creates a new response with the given content items.
     *
     * @param message the message to be included in the response
     * @return a successful response with single text content item
     */
    public static ToolResponse success(String message) {
        return new ToolResponse(false, List.of(new TextContent(message)));
    }

    public ToolResponse {
        if (content == null) {
            throw new IllegalArgumentException("content must not be null");
        }
    }

}
