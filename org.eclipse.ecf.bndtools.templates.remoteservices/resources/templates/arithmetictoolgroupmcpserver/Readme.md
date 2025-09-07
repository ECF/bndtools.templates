#ArithmeticToolGroup MCP Server

This project has an implementation of the ArithmeticToolGroup API/contract and two MCP Servers: One Sync and One Async Server.  
These two servers expose the sync and async
tools, respectively, from the ArithmeticToolGroup api contract, which should be in your workspace already, created by using the 
ArithmeticToolGroup API project template.  

To launch the ArithmeticToolGroup MCP Server

1. Open the file [mcpserver.bndrun](mcpserver.bndrun) in the bndrun editor
2. Click on Resolve button on right and then Set Cache
3. Choose Run OSGi or Debug OSGi in upper right to launch the MCP server

The debug output to the console should look similar to this

```console
Sep 07, 2025 9:36:49 AM org.apache.aries.spifly.BaseActivator log
INFO: Registered provider org.slf4j.simple.SimpleServiceProvider of service org.slf4j.spi.SLF4JServiceProvider in bundle slf4j.simple
[FelixStartLevel] DEBUG arith.mcpserver.AsyncMcpToolGroupServerComponent - starting async server with uds path=C:\Users\slewi\git\bndtools.workspace\arith.mcpserver\a.socket
[FelixStartLevel] DEBUG reactor.util.Loggers - Using Slf4j logging framework
[FelixStartLevel] DEBUG com.composent.ai.mcp.transport.uds.UDSMcpServerTransportProvider - Session transport initProcessing completed
[FelixStartLevel] DEBUG arith.mcpserver.AsyncMcpToolGroupServerComponent - async server started
[FelixStartLevel] DEBUG arith.mcpserver.SyncMcpToolGroupServerComponent - starting sync server with uds at path=C:\Users\slewi\git\bndtools.workspace\arith.mcpserver\s.socket
[FelixStartLevel] DEBUG com.composent.ai.mcp.transport.uds.UDSMcpServerTransportProvider - Session transport initProcessing completed
[FelixStartLevel] DEBUG arith.mcpserver.SyncMcpToolGroupServerComponent - sync server started
[FelixStartLevel] DEBUG com.github.victools.jsonschema.generator.impl.SchemaGenerationContextImpl - storing configured custom inline type for double as definition (since it is the main schema "#")
[FelixStartLevel] DEBUG com.github.victools.jsonschema.generator.impl.SchemaGenerationContextImpl - storing configured custom inline type for double as definition (since it is the main schema "#")
[FelixStartLevel] DEBUG com.composent.ai.mcp.toolgroup.provider.SyncMcpToolGroupProvider - created sync toolspec=SyncToolSpecification[tool=Tool[name=arith.api.ArithmeticToolGroup.add, title=null, description=computes the sum of the two double precision input arguments a and b, inputSchema=JsonSchema[type=object, properties={x={type=number, format=double, description=x is the first argument}, y={type=number, format=double, description=y is the second argument}}, required=[x, y], additionalProperties=null, defs=null, definitions=null], outputSchema=null, annotations=ToolAnnotations[title=, readOnlyHint=false, destructiveHint=true, idempotentHint=false, openWorldHint=true, returnDirect=null], meta=null], call=null, callHandler=org.springaicommunity.mcp.method.tool.SyncMcpToolMethodCallback@64a8cf04]
[FelixStartLevel] DEBUG com.github.victools.jsonschema.generator.impl.SchemaGenerationContextImpl - storing configured custom inline type for double as definition (since it is the main schema "#")
[FelixStartLevel] DEBUG com.github.victools.jsonschema.generator.impl.SchemaGenerationContextImpl - storing configured custom inline type for double as definition (since it is the main schema "#")
[FelixStartLevel] DEBUG com.composent.ai.mcp.toolgroup.provider.SyncMcpToolGroupProvider - created sync toolspec=SyncToolSpecification[tool=Tool[name=arith.api.ArithmeticToolGroup.multiply, title=null, description=return the product of the two given double precision arguments named a and b, inputSchema=JsonSchema[type=object, properties={x={type=number, format=double, description=x is the first argument}, y={type=number, format=double, description=y is the second argument}}, required=[x, y], additionalProperties=null, defs=null, definitions=null], outputSchema=null, annotations=ToolAnnotations[title=, readOnlyHint=false, destructiveHint=true, idempotentHint=false, openWorldHint=true, returnDirect=null], meta=null], call=null, callHandler=org.springaicommunity.mcp.method.tool.SyncMcpToolMethodCallback@3a2bedac]
[FelixStartLevel] DEBUG com.github.victools.jsonschema.generator.impl.SchemaGenerationContextImpl - storing configured custom inline type for java.lang.String as definition (since it is the main schema "#")
[FelixStartLevel] DEBUG com.composent.ai.mcp.toolgroup.provider.SyncMcpToolGroupProvider - created sync toolspec=SyncToolSpecification[tool=Tool[name=arith.api.ArithmeticToolGroup.get-image-and-message-tool, title=null, description=Tool returning CallToolResult with an image and message, inputSchema=JsonSchema[type=object, properties={message={type=string, description=Message to associate with image}}, required=[message], additionalProperties=null, defs=null, definitions=null], outputSchema=null, annotations=ToolAnnotations[title=, readOnlyHint=false, destructiveHint=true, idempotentHint=false, openWorldHint=true, returnDirect=null], meta=null], call=null, callHandler=org.springaicommunity.mcp.method.tool.SyncMcpToolMethodCallback@6fa845ec]
[FelixStartLevel] DEBUG io.modelcontextprotocol.server.McpAsyncServer - Added tool handler: arith.api.ArithmeticToolGroup.add
[FelixStartLevel] DEBUG com.composent.ai.mcp.toolgroup.AbstractSyncMcpToolGroupServer - added tool specification=arith.api.ArithmeticToolGroup.add to sync server=io.modelcontextprotocol.server.McpSyncServer@e91959
[FelixStartLevel] DEBUG io.modelcontextprotocol.server.McpAsyncServer - Added tool handler: arith.api.ArithmeticToolGroup.multiply
[FelixStartLevel] DEBUG com.composent.ai.mcp.toolgroup.AbstractSyncMcpToolGroupServer - added tool specification=arith.api.ArithmeticToolGroup.multiply to sync server=io.modelcontextprotocol.server.McpSyncServer@e91959
[FelixStartLevel] DEBUG io.modelcontextprotocol.server.McpAsyncServer - Added tool handler: arith.api.ArithmeticToolGroup.get-image-and-message-tool
[FelixStartLevel] DEBUG com.composent.ai.mcp.toolgroup.AbstractSyncMcpToolGroupServer - added tool specification=arith.api.ArithmeticToolGroup.get-image-and-message-tool to sync server=io.modelcontextprotocol.server.McpSyncServer@e91959
[FelixStartLevel] DEBUG com.github.victools.jsonschema.generator.impl.SchemaGenerationContextImpl - storing configured custom inline type for double as definition (since it is the main schema "#")
[FelixStartLevel] DEBUG com.github.victools.jsonschema.generator.impl.SchemaGenerationContextImpl - storing configured custom inline type for double as definition (since it is the main schema "#")
[FelixStartLevel] DEBUG com.composent.ai.mcp.toolgroup.provider.AsyncMcpToolGroupProvider - created async toolspec=AsyncToolSpecification[tool=Tool[name=arith.api.ArithmeticToolGroup.asyncAdd, title=null, description=asynchronously computes the sum of the two double precision input arguments a and b, inputSchema=JsonSchema[type=object, properties={x={type=number, format=double, description=x is the first argument}, y={type=number, format=double, description=y is the second argument}}, required=[x, y], additionalProperties=null, defs=null, definitions=null], outputSchema=null, annotations=ToolAnnotations[title=, readOnlyHint=false, destructiveHint=true, idempotentHint=false, openWorldHint=true, returnDirect=null], meta=null], call=null, callHandler=org.springaicommunity.mcp.method.tool.AsyncMcpToolMethodCallback@67f0716f]
[FelixStartLevel] DEBUG com.github.victools.jsonschema.generator.impl.SchemaGenerationContextImpl - storing configured custom inline type for double as definition (since it is the main schema "#")
[FelixStartLevel] DEBUG com.github.victools.jsonschema.generator.impl.SchemaGenerationContextImpl - storing configured custom inline type for double as definition (since it is the main schema "#")
[FelixStartLevel] DEBUG com.composent.ai.mcp.toolgroup.provider.AsyncMcpToolGroupProvider - created async toolspec=AsyncToolSpecification[tool=Tool[name=arith.api.ArithmeticToolGroup.asyncMultiply, title=null, description=asynchronously computes the product of the two given double precision arguments named a and b, inputSchema=JsonSchema[type=object, properties={x={type=number, format=double, description=x is the first argument}, y={type=number, format=double, description=y is the second argument}}, required=[x, y], additionalProperties=null, defs=null, definitions=null], outputSchema=null, annotations=ToolAnnotations[title=, readOnlyHint=false, destructiveHint=true, idempotentHint=false, openWorldHint=true, returnDirect=null], meta=null], call=null, callHandler=org.springaicommunity.mcp.method.tool.AsyncMcpToolMethodCallback@66cd7210]
[FelixStartLevel] DEBUG io.modelcontextprotocol.server.McpAsyncServer - Added tool handler: arith.api.ArithmeticToolGroup.asyncAdd
[FelixStartLevel] DEBUG com.composent.ai.mcp.toolgroup.AbstractAsyncMcpToolGroupServer - added tool specification=arith.api.ArithmeticToolGroup.asyncAdd to async server=io.modelcontextprotocol.server.McpAsyncServer@1c277988
[FelixStartLevel] DEBUG io.modelcontextprotocol.server.McpAsyncServer - Added tool handler: arith.api.ArithmeticToolGroup.asyncMultiply
[FelixStartLevel] DEBUG com.composent.ai.mcp.toolgroup.AbstractAsyncMcpToolGroupServer - added tool specification=arith.api.ArithmeticToolGroup.asyncMultiply to async server=io.modelcontextprotocol.server.McpAsyncServer@1c277988
____________________________
Welcome to Apache Felix Gogo

g! 
```

The McpAsyncServer and McpSyncServer are now running, waiting for MCP client connections on a.socket and s.socket unix domain socket file paths.

The ArithmeticToolGroup MCP Test Client project template can be used to create and then connect and then use the arithmetictoolgroup tools.
