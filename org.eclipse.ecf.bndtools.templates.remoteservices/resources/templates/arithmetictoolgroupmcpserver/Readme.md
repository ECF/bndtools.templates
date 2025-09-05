#MCP ArithmeticToolGroup Servers

This project has an implementation of the ArithmeticToolGroup API/contract and two MCP Servers: One Sync and One Async Server.  
These two servers expose the sync and async
tools, respectively, from the ArithmeticToolGroup api ontract, which should be in your workspace already, by using the 
MCP ArithmeticToolGroup API project template.  

At start/runtime, an McpAsyncServer and McpSyncServer are created via the AsyncMcpToolGroupServerComponent and 
SyncMcpToolGroupServerComponent classes.  Once these two MCP servers are created, they are injected
into the ArithmeticToolGroupComponent, and then upon component activation the sync and async tool specifications
are created from the appropriate methods in ArithmeticToolGroup.  See the activate method in the [ArithmeticToolGroupComponent](src/main/java/$basePackageDir$/ArithmeticToolGroupComponent.java#41)

##Next Steps:  Create MCP ArithmeticToolGroup Client using the MCP ArithmeticToolGroup Test Client project template via 
File->New->Bnd OSGi Project->MCP ArithmeticToolGroup Test Client.

