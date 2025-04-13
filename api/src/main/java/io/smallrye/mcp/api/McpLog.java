package io.smallrye.mcp.api;

/**
 * Send log message notifications to a connected MCP client.
 * <p>
 * See <a href="https://spec.modelcontextprotocol.io/specification/2024-11-05/server/utilities/logging">Logging</a>.
 * <p>
 * The MCP logger name is derived from the method. For example, if there is a method {@code myTool()} annotated with
 * {@code @Tool} then the logger name will be {@code tool:myTool}.
 */
public interface McpLog {

    /**
     *
     * @return the current log level
     */
    LogLevel level();

    /**
     * Sends a log message notification to the client if the specified level is higher or equal to the current level.
     *
     * @param level the log level
     * @param data the log message data
     */
    void send(LogLevel level, Object data);

    /**
     * Sends a log message notification to the client if the specified level is higher or equal to the current level.
     *
     * @param level the log level
     * @param format the log message format
     * @param params the log message parameters
     */
    void send(LogLevel level, String format, Object... params);

    /**
     * Logs a message and sends a {@link LogLevel#DEBUG} log message notification to the client.
     *
     * @param format the log message format
     * @param params the log message parameters
     */
    void debug(String format, Object... params);

    /**
     * Logs a message and sends a {@link LogLevel#INFO} log message notification to the client.
     *
     * @param format the log message format
     * @param params the log message parameters
     */
    void info(String format, Object... params);

    /**
     * Logs a message and sends a {@link LogLevel#ERROR} log message notification to the client.
     *
     * @param format the log message format
     * @param params the log message parameters
     */
    void error(String format, Object... params);

    /**
     * Logs a message and sends a {@link LogLevel#ERROR} log message notification to the client.
     *
     * @param t the error
     * @param format the log message format
     * @param params the log message parameters
     */
    void error(Throwable t, String format, Object... params);

    /**
     * See <a href="https://spec.modelcontextprotocol.io/specification/2024-11-05/server/utilities/logging/#log-levels">Log
     * Levels</a>.
     */
    enum LogLevel {
        DEBUG,
        INFO,
        NOTICE,
        WARNING,
        ERROR,
        CRITICAL,
        ALERT,
        EMERGENCY;

        public static LogLevel from(String val) {
            if (val == null || val.isBlank()) {
                return null;
            }
            try {
                return valueOf(val.toUpperCase());
            } catch (Exception e) {
                return null;
            }
        }

    }

}
