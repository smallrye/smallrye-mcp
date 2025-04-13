# SmallRye MCP

_"[Model Context Protocol](https://modelcontextprotocol.io/) (MCP) is an open protocol that enables seamless integration between LLM applications and external data sources and tools."_

This extension define a declarative APIs that enable developers to implement the MCP server features easily.

## Example of usage

Add server features (prompts, resources and tools) represented by _annotated business methods_ of beans.

```java
public class ServerFeatures {

    @Inject
    CodeService codeService;

    @Tool(description = "Converts the string value to lower case")
    String toLowerCase(String value) {
        return value.toLowerCase();
    }

    @Prompt(name = "code_assist")
    PromptMessage codeAssist(@PromptArg(name = "lang") String language) {
        return PromptMessage.withUserRole(new TextContent(codeService.assist(language)));
    }

    @Resource(uri = "file:///project/alpha")
    BlobResourceContents alpha(RequestUri uri) throws IOException{
        return BlobResourceContents.create(uri.value(), Files.readAllBytes(Paths.ALPHA));
    }

}
```
