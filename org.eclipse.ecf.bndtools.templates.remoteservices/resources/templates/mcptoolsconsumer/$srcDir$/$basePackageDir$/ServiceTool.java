package $basePackageName$;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.ecf.ai.mcp.tools.annotation.ToolParam;
import org.eclipse.ecf.ai.mcp.tools.util.ToolParamDescription;

import io.modelcontextprotocol.server.McpServerFeatures.SyncToolSpecification;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpSchema.CallToolResult;
import io.modelcontextprotocol.spec.McpSchema.JsonSchema;
import io.modelcontextprotocol.spec.McpSchema.Tool;

public class ServiceTool {
	
	protected Object serviceInstance;
	protected Class<?> serviceClass;
	protected Method toolMethod;
	protected org.eclipse.ecf.ai.mcp.tools.annotation.Tool toolAnnotation;
	protected String name;
	
	public ServiceTool(Object serviceInstance, Class<?> serviceClass, Method toolMethod, org.eclipse.ecf.ai.mcp.tools.annotation.Tool toolAnnotation) {
		this.serviceInstance = serviceInstance;
		this.serviceClass = serviceClass;
		this.toolMethod = toolMethod;
		this.toolAnnotation = toolAnnotation;
		this.name = this.serviceClass.getName() + "." + ("".equals(this.toolAnnotation.name()) ? toolMethod.getName() : this.toolAnnotation.name());
	}
	
	protected CallToolResult callTool(Map<String,Object> args) {
		Object[] methodArgs = Arrays.asList(this.toolMethod.getParameters()).stream().map(p -> {
			ToolParam tp = p.getAnnotation(ToolParam.class);
			if (tp != null) {
				String name = tp.name();
				if ("".equals(name)) {
					name = p.getName();
				}
				// this is the normal case
				return args.get(name);
			}
			return null;
		}).collect(Collectors.toList()).toArray();
		Object result = null;
		CallToolResult callToolResult = null;
		System.err.println("MCPSERVER calling toolMethod="+this.toolMethod.getName() + ";methodArgs="+ List.of(methodArgs) + ";instance="+ this.serviceInstance);
		try {
			result = this.toolMethod.invoke(this.serviceInstance, methodArgs);
			callToolResult = new CallToolResult(result == null ? null : result.toString(), false);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace(System.err);
			callToolResult = new CallToolResult(e.getMessage(), true);
		}
		System.err.println("MCPSERVER returning " + callToolResult + " for toolMethod=" + this.toolMethod.getName());
		return callToolResult;		
	}
	
	public String getName() {
		return this.name;
	}

	protected JsonSchema buildArgsSchema() {
		Map<String, Object> properties = new HashMap<String,Object>();
		List<String> required = new ArrayList<String>();
		List<ToolParamDescription> toolParamDescriptions = ToolParamDescription.fromParameters(this.toolMethod.getParameters());
		for (ToolParamDescription tpd: toolParamDescriptions) {
			required.add(String.valueOf(tpd.required()));
			properties.put("name", tpd.name());
			properties.put("description", tpd.description());
		}
		return new JsonSchema("object", properties, required, null, null, null);
	}
	
	protected McpSchema.Tool buildTool() {
		return new Tool(getName(), this.toolAnnotation.description(), buildArgsSchema());
	}
	
	protected SyncToolSpecification buildSyncToolSpecification() {
		return new SyncToolSpecification(buildTool(), (exchange, args) -> {
			return callTool(args);
		});
	}
	
	public void dispose() {
		synchronized (this) {
			this.serviceInstance = null;
			this.serviceClass = null;
			this.toolAnnotation = null;
			this.name = null;
		}
	}
	
}
