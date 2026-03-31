#MCP ToolGroups Example Servers Project

This project provides example implementations of two MCP Servers: One [synchronous](src/main/java/$basePackageDir$/SyncToolGroupServerImpl.java) and other [asynchronous](src/main/java/$basePackageDir$/AsyncToolGroupServerImpl.java). 

These two servers implement the sync and async tools, from the ArithmeticTools API, which should be an existing project in your workspace already, created via the MCP ToolGroups Example API Project template.  

The MCP ToolGroups Example API project must be present in the workspace for this example to compile or run.

To launch the MCP ToolGroups Example Servers Project

1. Open [mcpserver.bndrun](mcpserver.bndrun) in the Eclipse bndrun editor
2. Click on the Resolve button on right and then Set Cache
3. Choose Run OSGi or Debug OSGi in upper right to launch the MCP server in Run or Debug mode.

Startup debug output should be printed to the console

```console
Sep 07, 2025 9:36:49 AM org.apache.aries.spifly.BaseActivator log
INFO: Registered provider org.slf4j.simple.SimpleServiceProvider of service org.slf4j.spi.SLF4JServiceProvider in bundle slf4j.simple
[FelixStartLevel] DEBUG arith.mcpserver.AsyncMcpToolGroupServerComponent - starting async server with uds path=C:\Users\slewi\git\bndtools.workspace\arith.mcpserver\a.socket
[FelixStartLevel] DEBUG reactor.util.Loggers - Using Slf4j logging framework
[FelixStartLevel] DEBUG com.composent.ai.mcp.transport.uds.UDSMcpServerTransportProvider - Session transport initProcessing completed
...
```

The async and sync servers are now activated (running), waiting for MCP client uds connections using the UDS transport.

##Next Step: Create and Launch an MCP ToolGroups Example Client Project




