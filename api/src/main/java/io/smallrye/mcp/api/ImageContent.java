package io.smallrye.mcp.api;

/**
 * An image content provided to or from an LLM.
 *
 * @param data a base64-encoded string representing the image data (must not be {@code null})
 * @param mimeType the mime type of the image (must not be {@code null})
 */
public record ImageContent(String data, String mimeType) implements Content {

    public ImageContent {
        if (data == null) {
            throw new IllegalArgumentException("data must not be null");
        }
        if (mimeType == null) {
            throw new IllegalArgumentException("mimeType must not be null");
        }
    }

    @Override
    public Type type() {
        return Type.IMAGE;
    }

    @Override
    public TextContent asText() {
        throw new IllegalArgumentException("Not a text");
    }

    @Override
    public ImageContent asImage() {
        return this;
    }

    @Override
    public EmbeddedResource asResource() {
        throw new IllegalArgumentException("Not a resource");
    }
}
