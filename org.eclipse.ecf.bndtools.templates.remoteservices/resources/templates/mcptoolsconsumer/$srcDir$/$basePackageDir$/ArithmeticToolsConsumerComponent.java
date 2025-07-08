package $basePackageName$;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.modelcontextprotocol.server.McpServer;
import io.modelcontextprotocol.server.McpSyncServer;
import io.modelcontextprotocol.server.transport.StdioServerTransportProvider;
import io.modelcontextprotocol.spec.McpSchema.ServerCapabilities;
import $api_package$.ArithmeticTools;

@Component(immediate=true)
public class ArithmeticToolsConsumerComponent {

	@Reference
	private ArithmeticTools tools;
	private ServiceToolGroup toolGroup;
	private McpSyncServer server;
	
	@Activate
	void activate() throws Exception {
		this.toolGroup =  new ServiceToolGroup(tools, ArithmeticTools.class);
		// Create server
		this.server = McpServer.sync(new StdioServerTransportProvider(new ObjectMapper(), System.in, System.out))
				.serverInfo("arithmetic-server", "1.0.0")
				.capabilities(ServerCapabilities.builder().logging().tools(true).build())
				.build();
		// Add arithmetic sync tools from remote service to server
		this.toolGroup.addSyncTools(this.server);
	}

	@Deactivate
	void deactivate() throws Exception {
		if (this.toolGroup != null) {
			this.toolGroup.dispose();
			this.toolGroup = null;
		}
		if (this.server != null) {
			this.server.closeGracefully();
			this.server = null;
		}
	}
}
