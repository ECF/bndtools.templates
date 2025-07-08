#MCP Server/Arithmetic Tools Consumer Server

This project provides a MCP Server and consumer of the ArithmeticTools API.

Because this MCP server communicates with MCP clients via Stdio transport, it is not intended to be 
launched directly, but rather it will usually be launchedd by an MCP Client to that stdin and
stdout, and stderr can be used for MCP Client <-> MCP Server communication.  

The is a test MCP ArithmeticTools Client project template that can be used to launch this
server and make some tool calls to this MCP Server.

It is also possible to use the [MCP Inspector](https://github.com/modelcontextprotocol/inspector), Anthropic Claude, or any other MCP client instead of the MCP Client in myproject.mcpclient.  If using some other client, the command line to launch/start
this MCP server is:

```
<full path of java.exe 17+>/java -classpath "<full path of workspace>/$projectName$/generated/mcpserver.bndrun.jar" 
aQute.launcher.pre.EmbeddedLauncher
```

##Next Steps:  Create (or use existing) MCP ArithmeticTools Client

Create a new MCP ArithmeticTools Client by using the project template:  File->New->Bnd OSGi Project->MCP ArithmeticTools Client.

#Communication Path for MCP Client call of ArithmeticTools Remote Service

The basic communication path involves 4 processes:

1.  ArithmeticToools Server Impl:  Exports and publishes ArithmeticTools Remote Service
2.  MCP Server/ArithmeticTools Consumer (this project):  Discovers and imports ArithmeticTools Remote Service Proxy.  Also runs MCP Server and adds tools imported to MCP Server Tools List.  See 
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

