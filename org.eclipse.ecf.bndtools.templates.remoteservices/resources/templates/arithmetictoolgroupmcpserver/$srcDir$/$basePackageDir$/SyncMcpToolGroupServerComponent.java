package $basePackageName$;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.composent.ai.mcp.toolgroup.AbstractSyncMcpToolGroupServer;
import com.composent.ai.mcp.toolgroup.SyncMcpToolGroupServer;
import com.composent.ai.mcp.transport.uds.UDSMcpServerTransportProvider;

import io.modelcontextprotocol.server.McpServer;
import io.modelcontextprotocol.server.McpSyncServer;
import io.modelcontextprotocol.spec.McpSchema.ServerCapabilities;

@Component(immediate = true, service = { SyncMcpToolGroupServer.class })
public class SyncMcpToolGroupServerComponent extends AbstractSyncMcpToolGroupServer {

	private static Logger logger = LoggerFactory.getLogger(SyncMcpToolGroupServerComponent.class);
	// file named to be used for secure client <-> server uds communication
	private final Path socketPath = Paths.get("").resolve("s.socket").toAbsolutePath();

	private McpSyncServer server;

	@Activate
	void activate() throws Exception {
		// The s.socket file might still be there from previous run/debug, so we'll
		// delete it
		Files.deleteIfExists(socketPath);
		logger.debug("starting sync server with uds at path={}", socketPath);
		// Create unix domain socket transport
		UDSMcpServerTransportProvider transport = new UDSMcpServerTransportProvider(socketPath, true);
		// Create sync server
		this.server = McpServer.sync(transport)
				.serverInfo(SyncMcpToolGroupServerComponent.class.getName(), "1.0.0")
				.capabilities(ServerCapabilities.builder().tools(true).build()).build();
		logger.debug("sync server started");
	}

	@Deactivate
	void deactivate() throws Exception {
		if (this.server != null) {
			this.server.closeGracefully();
			this.server = null;
			Files.deleteIfExists(socketPath);
			logger.debug("sync server stopped");
		}
	}

	@Override
	protected McpSyncServer getServer() {
		return this.server;
	}

}
