package io.smallrye.mcp.api;

import jakarta.annotation.Priority;

/**
 * Encodes an object as {@link ToolResponse}.
 * <p>
 * If a tool response encoder exists and matches a specific return type then it always takes precedence over matching
 * {@link ContentEncoder}.
 * <p>
 * Implementation classes must be beans.
 * <p>
 * Encoders may define the priority with {@link Priority}.
 * An encoder with higher priority takes precedence.
 *
 * @param <TYPE>
 * @see ToolResponse
 * @see Tool
 */
public interface ToolResponseEncoder<TYPE> extends Encoder<TYPE, ToolResponse> {

}
