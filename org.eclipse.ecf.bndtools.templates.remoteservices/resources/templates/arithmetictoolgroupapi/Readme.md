#ArithmeticToolGroup API project

This project contains a single interface class: [ArithmeticToolGroup](src/main/java/$basePackageDir$/ArithmeticToolGroup.java).  This interface's
methods are annotated with @McpTool and @McpToolParam annotations from the Spring [mcp-annotation](https://github.com/spring-ai-community/mcp-annotations) project.
These annotations allow the developer to specify the tool descriptions meta-data directly as part of the interface contract.

There are both synchronous (plain return types), and asynchronous (reactive.Mono return types) defined in the ArithmeticToolGroup contract.  
McpSyncServer instances can expose the synchronous methods of the contract, and McpAsyncServer instances can expose the asynchronous methods.
 
##Next Steps: Create MCP ArithmeticToolGroup Server project

An implementation of ArithmeticToolGroup contract is in a project created via the MCP ArithmeticToolGroup Server roject template. 
To create a new project using this template choose File->New->Bnd OSGi Project->MCP ArithmeticToolGroup Server template.

Once the project is created, see the Readme.md in that project.