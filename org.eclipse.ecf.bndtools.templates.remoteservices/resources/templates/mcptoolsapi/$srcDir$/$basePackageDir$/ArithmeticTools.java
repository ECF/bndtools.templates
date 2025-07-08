package $basePackageName$;

import org.eclipse.ecf.ai.mcp.tools.annotation.Tool;
import org.eclipse.ecf.ai.mcp.tools.annotation.ToolParam;
import org.eclipse.ecf.ai.mcp.tools.annotation.ToolResult;
import org.eclipse.ecf.ai.mcp.tools.service.ToolGroupService;

public interface ArithmeticTools extends ToolGroupService {

	@Tool(description = "computes the sum of the two double precision input arguments a and b")
	@ToolResult(description = "the double precision result for this tool")
	double add(@ToolParam(description = "x is the first argument") double x, @ToolParam(description = "y is the second argument") double y);
	
	@Tool(description = "return the product of the two given double precision arguments named a and b")
	double multiply(@ToolParam(description = "x is the first argument") double x, @ToolParam(description = "y is the second argument") double y);
	
}
