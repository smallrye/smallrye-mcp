package io.smallrye.mcp.api;

/**
 * @param <TYPE> The type to be encoded
 * @param <ENCODED> The resulting type of encoding
 */
public interface Encoder<TYPE, ENCODED> {

    /**
     * Checks if this encoder can encode the provided type.
     *
     * @param runtimeType The runtime class of an object that should be encoded, must not be {@code null}
     * @return {@code true} if this encoder can encode the provided type, {@code false} otherwise
     */
    boolean supports(Class<?> runtimeType);

    /**
     * Encodes the provided value.
     *
     * @param value the value to encode, must not be {@code null}
     * @return the encoded value
     */
    ENCODED encode(TYPE value);

}
