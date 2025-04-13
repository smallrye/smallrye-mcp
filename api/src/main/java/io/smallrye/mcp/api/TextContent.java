package io.smallrye.mcp.api;

/**
 * A text content provided to or from an LLM.
 *
 * @param text (must not be {@code null})
 */
public record TextContent(String text) implements Content {

    public TextContent {
        if (text == null) {
            throw new IllegalArgumentException("text must not be null");
        }
    }

    @Override
    public Type type() {
        return Type.TEXT;
    }

    @Override
    public TextContent asText() {
        return this;
    }

    @Override
    public ImageContent asImage() {
        throw new IllegalArgumentException("Not an image");
    }

    @Override
    public EmbeddedResource asResource() {
        throw new IllegalArgumentException("Not a resource");
    }

}
