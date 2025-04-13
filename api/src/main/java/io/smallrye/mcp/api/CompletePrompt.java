package io.smallrye.mcp.api;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.List;
import java.util.concurrent.CompletionStage;

/**
 * Annotates a business method of a bean used to complete a prompt argument.
 * <p>
 * The result of a {@code complete} operation is always represented as a {@link CompletionResponse}.
 * However, the annotated method can also return other types that are converted according to the following rules:
 * <ul>
 * <li>If the method returns {@link String} then the response contains the single value.</li>
 * <li>If the method returns a {@link List} of {@link String}s then the response contains the list of values.</li>
 * <li>The method may return a {@link CompletionStage} or any supported async type that wraps any of the type mentioned
 * above.</li>
 * </ul>
 * In other words, the return type must be one of the following list:
 * <ul>
 * <li>{@code CompletionResponse}</li>
 * <li>{@code String}</li>
 * <li>{@code List<String>}</li>
 * <li>{@code CompletionStage<CompletionResponse>}</li>
 * <li>{@code CompletionStage<String>}</li>
 * <li>{@code CompletionStage<List<String>>}</li>
 * <li>{@code Uni<CompletionResponse>} if mutiny is supported</li>
 * <li>{@code Uni<String>} if mutiny is supported</li>
 * <li>{@code Uni<List<String>>} if mutiny is supported</li>
 * </ul>
 *
 * A prompt completion method must consume exactly one {@link String} argument.
 *
 * @see Prompt#name()
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface CompletePrompt {

    /**
     * The name reference to a prompt. If not such {@link Prompt} exists then the build fails.
     */
    String value();

}
