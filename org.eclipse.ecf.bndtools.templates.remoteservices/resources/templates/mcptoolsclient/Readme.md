#MCP ArithmeticTools Test Client

This project provides a test implementation of and MCP ArithmeticTools Client.

Upon startup, an MCP Server (myproject.mcpserver) is launched on localhost so that this client can communicate with it via stdio transport.   The code for this launching is in [McpClientComponent](src/main/java/$basePackageDir$/McpClientComponent.java).

##Launching MCP Tools Client/MCP Server

Before launching this MCP Tools Client the Arithmetic Tools Server project must be created and the server be launched.  See Readme.md in MCP rithmetic Tools Server
project for instructions for launch.

Once the ArithmeticTools Server is running, to start the MCP Tools Client/Server

1. Open the file [mcpclient.bndrun](mcpclient.bndrun) in the bndrun editor
2. Click on Resolve button on right and then Set Cache
3. Choose Run OSGi or Debug OSGi to launch the tools server

The output to the console will be similar to this

```console
Jul 07, 2025 2:10:42 PM org.apache.aries.spifly.BaseActivator log
INFO: Registered provider org.slf4j.simple.SimpleServiceProvider of service org.slf4j.spi.SLF4JServiceProvider in bundle slf4j.simple
[FelixStartLevel] DEBUG reactor.util.Loggers - Using Slf4j logging framework
[pool-5-thread-1] INFO io.modelcontextprotocol.client.transport.StdioClientTransport - STDERR Message received: Jul 07, 2025 2:10:44 PM org.apache.aries.spifly.BaseActivator log
[pool-5-thread-1] INFO io.modelcontextprotocol.client.transport.StdioClientTransport - STDERR Message received: INFO: Registered provider org.slf4j.simple.SimpleServiceProvider of service org.slf4j.spi.SLF4JServiceProvider in bundle slf4j.simple
[pool-2-thread-1] DEBUG io.modelcontextprotocol.spec.McpSchema - Received JSON message: {"jsonrpc":"2.0","method":"notifications/tools/list_changed"}
[pool-5-thread-1] INFO io.modelcontextprotocol.client.transport.StdioClientTransport - STDERR Message received: [pool-1-thread-1] INFO io.modelcontextprotocol.server.McpAsyncServer - Client initialize request - Protocol: 2024-11-05, Capabilities: ClientCapabilities[experimental=null, roots=null, sampling=null], Info: Implementation[name=Java SDK MCP Client, version=1.0.0]
[pool-2-thread-1] DEBUG io.modelcontextprotocol.spec.McpClientSession - Received notification: JSONRPCNotification[jsonrpc=2.0, method=notifications/tools/list_changed, params=null]
[pool-2-thread-1] DEBUG io.modelcontextprotocol.spec.McpSchema - Received JSON message: {"jsonrpc":"2.0","method":"notifications/tools/list_changed"}
[pool-2-thread-1] DEBUG io.modelcontextprotocol.spec.McpClientSession - Received notification: JSONRPCNotification[jsonrpc=2.0, method=notifications/tools/list_changed, params=null]
[pool-2-thread-1] DEBUG io.modelcontextprotocol.spec.McpSchema - Received JSON message: {"jsonrpc":"2.0","id":"c6ae39b5-0","result":{"protocolVersion":"2024-11-05","capabilities":{"logging":{},"tools":{"listChanged":true}},"serverInfo":{"name":"arithmetic-server","version":"1.0.0"}}}
[pool-2-thread-1] DEBUG io.modelcontextprotocol.spec.McpClientSession - Received Response: JSONRPCResponse[jsonrpc=2.0, id=c6ae39b5-0, result={protocolVersion=2024-11-05, capabilities={logging={}, tools={listChanged=true}}, serverInfo={name=arithmetic-server, version=1.0.0}}, error=null]
[pool-2-thread-1] INFO io.modelcontextprotocol.client.McpAsyncClient - Server response with Protocol: 2024-11-05, Capabilities: ServerCapabilities[completions=null, experimental=null, logging=LoggingCapabilities[], prompts=null, resources=null, tools=ToolCapabilities[listChanged=true]], Info: Implementation[name=arithmetic-server, version=1.0.0] and Instructions null
[FelixStartLevel] DEBUG myproject.mcpclient.McpClientComponent - MCPCLIENT initialized
[pool-2-thread-1] DEBUG io.modelcontextprotocol.spec.McpSchema - Received JSON message: {"jsonrpc":"2.0","id":"c6ae39b5-1","result":{"tools":[{"name":"myproject.api.ArithmeticTools.add","description":"computes the sum of the two double precision input arguments a and b","inputSchema":{"type":"object","properties":{"name":"y","description":"y is the second argument"},"required":["true","true"]}},{"name":"myproject.api.ArithmeticTools.multiply","description":"return the product of the two given double precision arguments named a and b","inputSchema":{"type":"object","properties":{"name":"y","description":"y is the second argument"},"required":["true","true"]}}]}}
[pool-2-thread-1] DEBUG io.modelcontextprotocol.spec.McpClientSession - Received Response: JSONRPCResponse[jsonrpc=2.0, id=c6ae39b5-1, result={tools=[{name=myproject.api.ArithmeticTools.add, description=computes the sum of the two double precision input arguments a and b, inputSchema={type=object, properties={name=y, description=y is the second argument}, required=[true, true]}}, {name=myproject.api.ArithmeticTools.multiply, description=return the product of the two given double precision arguments named a and b, inputSchema={type=object, properties={name=y, description=y is the second argument}, required=[true, true]}}]}, error=null]
[pool-2-thread-1] DEBUG io.modelcontextprotocol.client.McpAsyncClient - Tools changed: [Tool[name=myproject.api.ArithmeticTools.add, description=computes the sum of the two double precision input arguments a and b, inputSchema=JsonSchema[type=object, properties={name=y, description=y is the second argument}, required=[true, true], additionalProperties=null, defs=null, definitions=null]], Tool[name=myproject.api.ArithmeticTools.multiply, description=return the product of the two given double precision arguments named a and b, inputSchema=JsonSchema[type=object, properties={name=y, description=y is the second argument}, required=[true, true], additionalProperties=null, defs=null, definitions=null]]]
[pool-2-thread-1] DEBUG io.modelcontextprotocol.spec.McpSchema - Received JSON message: {"jsonrpc":"2.0","id":"c6ae39b5-2","result":{"tools":[{"name":"myproject.api.ArithmeticTools.add","description":"computes the sum of the two double precision input arguments a and b","inputSchema":{"type":"object","properties":{"name":"y","description":"y is the second argument"},"required":["true","true"]}},{"name":"myproject.api.ArithmeticTools.multiply","description":"return the product of the two given double precision arguments named a and b","inputSchema":{"type":"object","properties":{"name":"y","description":"y is the second argument"},"required":["true","true"]}}]}}
[pool-2-thread-1] DEBUG io.modelcontextprotocol.spec.McpClientSession - Received Response: JSONRPCResponse[jsonrpc=2.0, id=c6ae39b5-2, result={tools=[{name=myproject.api.ArithmeticTools.add, description=computes the sum of the two double precision input arguments a and b, inputSchema={type=object, properties={name=y, description=y is the second argument}, required=[true, true]}}, {name=myproject.api.ArithmeticTools.multiply, description=return the product of the two given double precision arguments named a and b, inputSchema={type=object, properties={name=y, description=y is the second argument}, required=[true, true]}}]}, error=null]
[pool-2-thread-1] DEBUG io.modelcontextprotocol.client.McpAsyncClient - Tools changed: [Tool[name=myproject.api.ArithmeticTools.add, description=computes the sum of the two double precision input arguments a and b, inputSchema=JsonSchema[type=object, properties={name=y, description=y is the second argument}, required=[true, true], additionalProperties=null, defs=null, definitions=null]], Tool[name=myproject.api.ArithmeticTools.multiply, description=return the product of the two given double precision arguments named a and b, inputSchema=JsonSchema[type=object, properties={name=y, description=y is the second argument}, required=[true, true], additionalProperties=null, defs=null, definitions=null]]]
[pool-2-thread-1] DEBUG io.modelcontextprotocol.spec.McpSchema - Received JSON message: {"jsonrpc":"2.0","id":"c6ae39b5-3","result":{"tools":[{"name":"myproject.api.ArithmeticTools.add","description":"computes the sum of the two double precision input arguments a and b","inputSchema":{"type":"object","properties":{"name":"y","description":"y is the second argument"},"required":["true","true"]}},{"name":"myproject.api.ArithmeticTools.multiply","description":"return the product of the two given double precision arguments named a and b","inputSchema":{"type":"object","properties":{"name":"y","description":"y is the second argument"},"required":["true","true"]}}]}}
[pool-2-thread-1] DEBUG io.modelcontextprotocol.spec.McpClientSession - Received Response: JSONRPCResponse[jsonrpc=2.0, id=c6ae39b5-3, result={tools=[{name=myproject.api.ArithmeticTools.add, description=computes the sum of the two double precision input arguments a and b, inputSchema={type=object, properties={name=y, description=y is the second argument}, required=[true, true]}}, {name=myproject.api.ArithmeticTools.multiply, description=return the product of the two given double precision arguments named a and b, inputSchema={type=object, properties={name=y, description=y is the second argument}, required=[true, true]}}]}, error=null]
[FelixStartLevel] DEBUG myproject.mcpclient.McpClientComponent - MCPCLIENT seeing tool=Tool[name=myproject.api.ArithmeticTools.add, description=computes the sum of the two double precision input arguments a and b, inputSchema=JsonSchema[type=object, properties={name=y, description=y is the second argument}, required=[true, true], additionalProperties=null, defs=null, definitions=null]]
[FelixStartLevel] DEBUG myproject.mcpclient.McpClientComponent - MCPCLIENT seeing tool=Tool[name=myproject.api.ArithmeticTools.multiply, description=return the product of the two given double precision arguments named a and b, inputSchema=JsonSchema[type=object, properties={name=y, description=y is the second argument}, required=[true, true], additionalProperties=null, defs=null, definitions=null]]
[FelixStartLevel] DEBUG myproject.mcpclient.McpClientComponent - MCPCLIENT: Calling tool:  myproject.api.ArithmeticTools.add({y=3, x=5})
[pool-5-thread-1] INFO io.modelcontextprotocol.client.transport.StdioClientTransport - STDERR Message received: MCPSERVER calling toolMethod=add;methodArgs=[5, 3];instance=myproject.api.ArithmeticTools.proxy@org.eclipse.ecf.remoteservice.RemoteServiceID[containerID=StringID[ecftcp://LAPTOP-E2NLR1T7.domain:61959/server];containerRelativeID=1]
[pool-5-thread-1] INFO io.modelcontextprotocol.client.transport.StdioClientTransport - STDERR Message received: MCPSERVER returning CallToolResult[content=[TextContent[audience=null, priority=null, text=8.0]], isError=false] for toolMethod=add
[pool-2-thread-1] DEBUG io.modelcontextprotocol.spec.McpSchema - Received JSON message: {"jsonrpc":"2.0","id":"c6ae39b5-4","result":{"content":[{"type":"text","text":"8.0"}],"isError":false}}
[pool-2-thread-1] DEBUG io.modelcontextprotocol.spec.McpClientSession - Received Response: JSONRPCResponse[jsonrpc=2.0, id=c6ae39b5-4, result={content=[{type=text, text=8.0}], isError=false}, error=null]
[FelixStartLevel] DEBUG myproject.mcpclient.McpClientComponent - MCPCLIENT: call tool=myproject.api.ArithmeticTools.add result=8.0
[FelixStartLevel] DEBUG myproject.mcpclient.McpClientComponent - MCPCLIENT: Calling tool:  myproject.api.ArithmeticTools.multiply({y=974, x=523})
[pool-5-thread-1] INFO io.modelcontextprotocol.client.transport.StdioClientTransport - STDERR Message received: MCPSERVER calling toolMethod=multiply;methodArgs=[523, 974];instance=myproject.api.ArithmeticTools.proxy@org.eclipse.ecf.remoteservice.RemoteServiceID[containerID=StringID[ecftcp://LAPTOP-E2NLR1T7.domain:61959/server];containerRelativeID=1]
[pool-5-thread-1] INFO io.modelcontextprotocol.client.transport.StdioClientTransport - STDERR Message received: MCPSERVER returning CallToolResult[content=[TextContent[audience=null, priority=null, text=509402.0]], isError=false] for toolMethod=multiply
[pool-2-thread-1] DEBUG io.modelcontextprotocol.spec.McpSchema - Received JSON message: {"jsonrpc":"2.0","id":"c6ae39b5-5","result":{"content":[{"type":"text","text":"509402.0"}],"isError":false}}
[pool-2-thread-1] DEBUG io.modelcontextprotocol.spec.McpClientSession - Received Response: JSONRPCResponse[jsonrpc=2.0, id=c6ae39b5-5, result={content=[{type=text, text=509402.0}], isError=false}, error=null]
[FelixStartLevel] DEBUG myproject.mcpclient.McpClientComponent - MCPCLIENT: call tool=myproject.api.ArithmeticTools.multiply result=509402.0
```

At the bottom of the console output note that this is the test code in [McpClientComponent](../myproject.mcpclient/src/main/java/myproject/mcpclient/McpClientComponent.java) starting on line 63

```java
		// TEST list tools from server
		client.listTools().tools().forEach(t -> logger.debug("MCPCLIENT seeing tool=" + t.toString()));

		// TEST: Call 'add' 
		callTool(client, ARITHMETIC_SERVICE + "add", Map.of("x", 5, "y", 3));

		// TEST: Call 'multiply'
		callTool(client, ARITHMETIC_SERVICE + "multiply", Map.of("x", 523, "y", 974));
```

#Communication Path for MCP Client call of ArithmeticTools Remote Service

The basic communication path involves 4 processes:

1.  ArithmeticToools Server Impl (this project):  Exports and publishes ArithmeticTools Remote Service
2.  MCP Server/ArithmeticTools Consumer:  Discovers and imports ArithmeticTools Remote Service Proxy.  Also runs MCP Server and adds tools imported to MCP Server Tools List.  See 
3.  MCP ArithmeticTools Client. Launches MCP Server (2) as separate process and uses stdio transport for MCP client -> MCP Server communication.

The communication path of an MCP client call of add 5 and 3 is as follows:

```
MCP Client (3)-> 
     Stdio -> 
          MCP Server/ArithmeticTools Consumer (2) ->
               Discovers and Imports ArithmeticTools Remote Service Proxy ->
                   ArithmeticTools Server (1) ->
                        Exports and Publishes Remote ArithmeticToolsComponent
                             Implements 'add' and 'multiply' tools
                        					
```
To have the above MCP call succeed, the ArithmeticTools Server (1) must be started before the MCP Tool Example Client/MCP Server (3,2) processes are launched.  
