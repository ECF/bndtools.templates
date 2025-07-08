package $basePackageName$;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.ServerParameters;
import io.modelcontextprotocol.client.transport.StdioClientTransport;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.CallToolResult;
import io.modelcontextprotocol.spec.McpSchema.ClientCapabilities;
import io.modelcontextprotocol.spec.McpSchema.TextContent;

@Component(immediate=true)
public class McpClientComponent {

	private static Logger logger = LoggerFactory.getLogger(McpClientComponent.class);
	
	private static Path SERVER_APP_JAR = Paths.get("$mcp_server_project$","generated","mcpserver.bndrun.jar");

	private static String ARITHMETIC_SERVICE = "$api_package$.ArithmeticTools.";
	
	// Client created in activate()
	private McpSyncClient client;
	
	@Activate
	void activate() throws Exception {
		// The following ServerParameters setup launches as a java application an OSGi-implemented MCP Server in project
		// The command is java.home/bin/java
		ServerParameters.Builder spBuilder = ServerParameters.builder(Path.of(System.getProperty("java.home"), "bin", "java").toAbsolutePath().toString());
		// this is jar in ../myproject.mcpserver/generated/myproject.mcpserver.bndrun.jar
		String classpath_jar = Paths.get("").toAbsolutePath().getParent().resolve(SERVER_APP_JAR).toAbsolutePath().toString();
		// Add the classpath_jar to the classpath for the server launch.  Also add EmbeddedLauncher class as main
		spBuilder.args("-classpath", "\"" + classpath_jar + "\"" ,"aQute.launcher.pre.EmbeddedLauncher");
		
		// Create StdioClient transport from ServerParameters Builder
		StdioClientTransport transport = new StdioClientTransport(spBuilder
			    .build());
		// Create client with stdio transport and some reasonable default timeouts for stdio
		client = McpClient.sync(transport)
		    .requestTimeout(Duration.ofSeconds(1000))
		    .capabilities(ClientCapabilities.builder()
		        .build())
	        .build();

		// start and connect to stdio server. This will launch the server defined in ServerParameters and then use the Stdio
		// transport to communicate with it/initialize the connection.
		client.initialize();
		
		logger.debug("MCPCLIENT initialized");
		
		// TEST list tools from server
		client.listTools().tools().forEach(t -> logger.debug("MCPCLIENT seeing tool=" + t.toString()));

		// TEST: Call 'add' 
		callTool(client, ARITHMETIC_SERVICE + "add", Map.of("x", 5, "y", 3));

		// TEST: Call 'multiply'
		callTool(client, ARITHMETIC_SERVICE + "multiply", Map.of("x", 523, "y", 974));

	}
	
	private void callTool(McpSyncClient client, String tool_name, Map<String,Object> args) {
		logger.debug("MCPCLIENT: Calling tool:  "+ tool_name + "(" + args + ")");
		CallToolResult result = client.callTool(
			    new CallToolRequest(tool_name, 
			        args)
			);
		logger.debug("MCPCLIENT: call tool=" + tool_name + " result=" + ((TextContent) result.content().get(0)).text());
	}

	@Deactivate
	void deactivate() {
		if (this.client != null) {
			this.client.closeGracefully();
			this.client = null;
		}
	}
	
}
