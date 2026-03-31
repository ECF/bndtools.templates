#MCP ToolGroups Example Client Project

This project provides a MCP ToolGroups Example Client to connect to
and test an MCP ToolGroups Example Server.

##Prerequisite:  Launched MCP ToolGroups Example Servers

A MCP ToolGroups Example Servers project in the current workspace must be created and be launched so that this example client may 
connect to it. 

Once the servers are running (see the Readme.md in the MCP ToolGroups Example Servers project in your workspace) you may run
the MCP ToolGroups Example Client:

1. Open [mcpclient.bndrun](mcpclient.bndrun) in the Eclipse bndrun editor
2. Click on the Resolve button on right and then Set Cache
3. Choose Run OSGi or Debug OSGi to launch the tools server

The output to the console will be similar to this

```console
Sep 07, 2025 9:38:01 AM org.apache.aries.spifly.BaseActivator log
INFO: Registered provider org.slf4j.simple.SimpleServiceProvider of service org.slf4j.spi.SLF4JServiceProvider in bundle slf4j.simple
[FelixStartLevel] DEBUG arith.mcpclient.McpAsyncClientComponent - starting uds async client with socket path=C:\Users\slewi\git\bndtools.workspace\arith.mcpserver\a.socket
[FelixStartLevel] DEBUG reactor.util.Loggers - Using Slf4j logging framework
[FelixStartLevel] DEBUG io.modelcontextprotocol.client.LifecycleInitializer - Initialization process started
[boundedElastic-1] DEBUG org.eclipse.ecf.ai.mcp.transports.AbstractStringChannel - connect targetAddress=C:\Users\slewi\git\bndtools.workspace\arith.mcpserver\a.socket
[boundedElastic-1] DEBUG org.eclipse.ecf.ai.mcp.transports.AbstractStringChannel - connect targetAddress=C:\Users\slewi\git\bndtools.workspace\arith.mcpserver\a.socket
...
```
