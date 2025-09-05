package $basePackageName$;

import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;

import io.modelcontextprotocol.spec.McpSchema.CallToolResult;
import reactor.core.publisher.Mono;

public interface ArithmeticToolGroup {

	@McpTool(description = "computes the sum of the two double precision input arguments a and b")
	double add(@McpToolParam(description = "x is the first argument") double x,
			@McpToolParam(description = "y is the second argument") double y);

	@McpTool(description = "return the product of the two given double precision arguments named a and b")
	double multiply(@McpToolParam(description = "x is the first argument") double x,
			@McpToolParam(description = "y is the second argument") double y);

	@McpTool(name = "get-image-and-message-tool", description = "Tool returning CallToolResult with an image and message")
	public CallToolResult getImageAndMessage(
			@McpToolParam(description = "Message to associate with image") String message);

	@McpTool(description = "asynchronously computes the sum of the two double precision input arguments a and b")
	Mono<Double> asyncAdd(@McpToolParam(description = "x is the first argument") double x,
			@McpToolParam(description = "y is the second argument") double y);

	@McpTool(description = "asynchronously computes the product of the two given double precision arguments named a and b")
	Mono<Double> asyncMultiply(@McpToolParam(description = "x is the first argument") double x,
			@McpToolParam(description = "y is the second argument") double y);

}
