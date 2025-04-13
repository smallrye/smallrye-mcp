package io.smallrye.mcp.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Text data of a resource.
 *
 * @param uri (must not be {@code null})
 * @param text (must not be {@code null})
 * @param mimeType the mime type of this resource
 */
@JsonInclude(Include.NON_NULL)
public record TextResourceContents(String uri, String text, String mimeType) implements ResourceContents {

    /**
     * Creates a new text resource contents with the given URI and text.
     *
     * @param uri the URI of the resource
     * @param text the text of the resource
     * @return a new text resource contents
     */
    public static TextResourceContents create(String uri, String text) {
        return new TextResourceContents(uri, text, null);
    }

    /**
     * Creates a new text resource contents with the given URI, text, and mime type.
     *
     * @param uri the URI of the resource
     * @param text the text of the resource
     * @param mimeType the mime type of the resource
     */
    public TextResourceContents {
        if (uri == null) {
            throw new IllegalArgumentException("uri must not be null");
        }
        if (text == null) {
            throw new IllegalArgumentException("text must not be null");
        }
    }

    @Override
    public Type type() {
        return Type.TEXT;
    }

    @Override
    public TextResourceContents asText() {
        return this;
    }

    @Override
    public BlobResourceContents asBlob() {
        throw new IllegalArgumentException("Not a blob");
    }

}
