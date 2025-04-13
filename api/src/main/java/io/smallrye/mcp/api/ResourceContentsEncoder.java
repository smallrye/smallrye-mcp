package io.smallrye.mcp.api;

import jakarta.annotation.Priority;

/**
 * Encodes an object as {@link ResourceContents}.
 * <p>
 * Implementation classes must be beans. Qualifiers are ignored.
 * <p>
 * Encoders may define the priority with {@link Priority}. An encoder with higher priority takes precedence.
 *
 * @param <TYPE>
 * @see ResourceContents
 * @see Resource
 * @see ResourceTemplate
 */
public interface ResourceContentsEncoder<TYPE>
        extends Encoder<ResourceContentsEncoder.ResourceContentsData<TYPE>, ResourceContents> {

    record ResourceContentsData<TYPE>(RequestUri uri, TYPE data) {
    }

}
