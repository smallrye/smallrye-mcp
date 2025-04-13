package io.smallrye.mcp.api;

import java.util.Map;

/**
 * A capability supported by the client.
 */
public record ClientCapability(String name, Map<String, Object> properties) {

    public static final String ROOTS = "roots";

    public static final String SAMPLING = "sampling ";

}
