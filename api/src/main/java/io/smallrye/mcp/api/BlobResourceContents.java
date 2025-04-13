package io.smallrye.mcp.api;

import java.util.Base64;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Binary data of a resource.
 *
 * @param uri (must not be {@code null})
 * @param blob a base64-encoded string representing the binary data of the item (must not be {@code null})
 * @param mimeType the mime type of this resource
 */
@JsonInclude(Include.NON_NULL)
public record BlobResourceContents(String uri, String blob, String mimeType) implements ResourceContents {

    /**
     * Create a new binary resource contents.
     *
     * @param uri the URI of the resource
     * @param blob the base64-encoded string representing the binary data of the item
     * @return a new binary resource contents
     */
    public static BlobResourceContents create(String uri, String blob) {
        return new BlobResourceContents(uri, blob, null);
    }

    /**
     * Create a new binary resource contents.
     *
     * @param uri the URI of the resource
     * @param blob the byte array representing the binary data of the item
     * @return a new binary resource contents
     */
    public static BlobResourceContents create(String uri, byte[] blob) {
        return new BlobResourceContents(uri, Base64.getMimeEncoder().encodeToString(blob), null);
    }

    public BlobResourceContents {
        if (uri == null) {
            throw new IllegalArgumentException("uri must not be null");
        }
        if (blob == null) {
            throw new IllegalArgumentException("blob must not be null");
        }
    }

    @Override
    public Type type() {
        return Type.BLOB;
    }

    @Override
    public TextResourceContents asText() {
        throw new IllegalArgumentException("Not a text");
    }

    @Override
    public BlobResourceContents asBlob() {
        return this;
    }

}
