package $basePackageName$;

import java.nio.file.Path;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.composent.ai.mcp.transport.uds.UDSMcpClientTransport;

import io.modelcontextprotocol.client.McpAsyncClient;
import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.ClientCapabilities;
import io.modelcontextprotocol.spec.McpSchema.Content;
import io.modelcontextprotocol.spec.McpSchema.TextContent;

@Component(immediate = true)
public class McpAsyncClientComponent {

	private static final String ARITHMETIC_TOOLGROUP_NAME = "$api_package$.ArithmeticToolGroup.%s";

	private static Logger logger = LoggerFactory.getLogger(McpAsyncClientComponent.class);

	private final Path socketPath = Path.of("").toAbsolutePath().getParent().resolve("$mcp_server_project$")
			.resolve("a.socket").toAbsolutePath();

	private McpAsyncClient client;

	@Activate
	void activate() throws Exception {
		logger.debug("starting uds async client with socket path={}", socketPath);
		// create UDS transport via the socketPath (default is
		UDSMcpClientTransport transport = new UDSMcpClientTransport(socketPath);
		// Create client with transport
		client = McpClient.async(transport).capabilities(ClientCapabilities.builder().build()).build();

		// initialize will connect to server
		client.initialize().block();
		logger.debug("uds async client initialized");

		// test list tools from server
		client.listTools().doOnSuccess(result -> result.tools()
				.forEach(tool -> logger.debug("uds async client seeing tool=" + tool.toString())));

		String x = "25.1";
		String y = "26.32";
		// Call asyncAdd(25.1,26.32)
		client.callTool(
				new CallToolRequest(String.format(ARITHMETIC_TOOLGROUP_NAME, "asyncAdd"), Map.of("x", x, "y", y)))
				.doOnSuccess(result -> result.content()
						.forEach(content -> printTextContent("asyncAdd(" + x + "," + y + ")", content)))
				.subscribe();

		String x1 = "210.71";
		String y1 = "223.86";
		// Call multiply(210.71,223.86)
		client.callTool(new CallToolRequest(String.format(ARITHMETIC_TOOLGROUP_NAME, "asyncMultiply"),
				Map.of("x", x1, "y", y1)))
				.doOnSuccess(result -> result.content()
						.forEach(content -> printTextContent("asyncMultiply(" + x1 + "," + y1 + ")", content)))
				.subscribe();

	}

	void printTextContent(String op, Content content) {
		if (content instanceof TextContent) {
			logger.debug(op + " result=" + ((TextContent) content).text());
		}
	}

	@Deactivate
	void deactivate() {
		if (this.client != null) {
			this.client.closeGracefully();
			this.client = null;
			logger.debug("uds async client closed");
		}
	}

}
