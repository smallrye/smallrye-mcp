package io.smallrye.mcp.api;

import java.io.Serial;

/**
 * Indicates a business logic error in a {@link Tool} method.
 * <p>
 * If a method annotated with {@link Tool} throws an exception that is an instance of {@link ToolCallException} then it is
 * automatically converted to a failed {@link ToolResponse}. The message of the exception is used as the text of the result
 * content.
 * <p>
 * See <a href="https://spec.modelcontextprotocol.io/specification/2024-11-05/server/tools/#error-handling">Error Handling</a>
 */
public class ToolCallException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 6214164159077697693L;

    public ToolCallException(String message, Throwable cause) {
        super(message, cause);
    }

    public ToolCallException(String message) {
        super(message);
    }

    public ToolCallException(Throwable cause) {
        super(cause);
    }

}
