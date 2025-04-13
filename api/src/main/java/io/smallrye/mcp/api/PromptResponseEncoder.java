package io.smallrye.mcp.api;

import jakarta.annotation.Priority;

/**
 * Encodes an object as {@link PromptResponse}.
 * <p>
 * If a prompt response encoder exists and matches a specific return type then it always takes precedence over matching
 * {@link ContentEncoder}.
 * <p>
 * Implementation classes must be beans. Qualifiers are ignored.
 * <p>
 * Encoders may define the priority with {@link Priority}. An encoder with higher priority takes precedence.
 *
 * @param <TYPE>
 * @see PromptResponse
 * @see Prompt
 */
public interface PromptResponseEncoder<TYPE> extends Encoder<TYPE, PromptResponse> {

}
