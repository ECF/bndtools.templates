package $basePackageName$.math;

import org.openmcptools.annotation.McpArg;
import org.openmcptools.annotation.McpTool;
import org.openmcptools.annotation.McpToolGroup;

import reactor.core.publisher.Mono;

// Define a toolgroup from the ArithmeticTools class. The default name
// for this toolgroup will be the class name i.e. 'ArithmeticTools' unless
// overridden by providing an explicit name
@McpToolGroup(title = "ArithmeticTools", description = "Arithmetic operations exposed as mcp tools")
public interface ArithmeticTools {

	@McpTool(description = "return the sum of the two double precision input arguments a and b")
	double add(@McpArg(description = "x is the first argument") double x,
			@McpArg(description = "y is the second argument") double y);

	@McpTool(description = "return the product of the two given double precision arguments named a and b")
	double multiply(@McpArg(description = "x is the first argument") double x,
			@McpArg(description = "y is the second argument") double y);

	@McpTool(description = "asynchronously computes the sum of the two double precision input arguments a and b")
	Mono<Double> asyncAdd(@McpArg(description = "x is the first argument") double x,
			@McpArg(description = "y is the second argument") double y);

	@McpTool(description = "asynchronously computes the product of the two given double precision arguments named a and b")
	Mono<Double> asyncMultiply(@McpArg(description = "x is the first argument") double x,
			@McpArg(description = "y is the second argument") double y);

}
