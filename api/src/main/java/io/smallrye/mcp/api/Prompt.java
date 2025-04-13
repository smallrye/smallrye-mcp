package io.smallrye.mcp.api;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.List;

/**
 * Annotates a business method of a bean as an exposed prompt template.
 * <p>
 * The result of a {@code prompt get} operation is always represented as a {@link PromptResponse}.
 * However, the annotated method can also return other types that are converted according to the following rules.
 * <p>
 * <ul>
 * <li>If it returns a {@link PromptMessage} then the response has no description and contains the single
 * message object.</li>
 * <li>If it returns a {@link List} of {@link PromptMessage}s then the response has no description and contains the
 * list of messages.</li>
 * <li>If it returns any other type {@code X} then {@code X} is encoded using the {@link PromptResponseEncoder} API.</li>
 * <li>It may also return a {@link java.util.concurrent.CompletionStage} or other async types that wraps any of the type
 * mentioned above.</li>
 * </ul>
 *
 * @see PromptResponse
 * @see PromptArg
 * @see PromptResponseEncoder
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface Prompt {

    /**
     * Constant value for {@link #name()} indicating that the annotated element's name should be used as-is.
     */
    String ELEMENT_NAME = "<<element name>>";

    /**
     * Each prompt must have a unique name. By default, the name is derived from the name of the annotated method.
     */
    String name() default ELEMENT_NAME;

    /**
     * An optional description.
     */
    String description() default "";

}
