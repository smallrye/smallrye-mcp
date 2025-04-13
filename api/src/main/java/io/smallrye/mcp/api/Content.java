package io.smallrye.mcp.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A content provided to or from an LLM.
 */
public sealed interface Content permits TextContent, ImageContent, EmbeddedResource {

    /**
     *
     * @return the type of the content
     */
    Type type();

    /**
     * Casts and returns this object as a text content, or throws an {@link IllegalArgumentException} if the content object does
     * not represent a {@link TextContent}.
     *
     * @return the text content
     */
    TextContent asText();

    /**
     * Casts and returns this object as an image content, or throws an {@link IllegalArgumentException} if the content object
     * does not represent a {@link ImageContent}.
     *
     * @return the image content
     */
    ImageContent asImage();

    /**
     * Casts and returns this object as an embedded resource content, or throws an {@link IllegalArgumentException} if the
     * content object does not represent a {@link EmbeddedResource}.
     *
     * @return the image content
     */
    EmbeddedResource asResource();

    @JsonProperty("type")
    default String getType() {
        return type().toString().toLowerCase();
    }

    enum Type {
        TEXT,
        IMAGE,
        RESOURCE
    }

}
