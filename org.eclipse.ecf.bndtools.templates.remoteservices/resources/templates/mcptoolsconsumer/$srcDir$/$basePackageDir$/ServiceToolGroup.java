package $basePackageName$;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import io.modelcontextprotocol.server.McpSyncServer;

public class ServiceToolGroup {
	
	protected final Object serviceInstance;
	protected final Class<?> serviceClass;
	protected final Map<String,ServiceTool> serviceToolMap = new HashMap<String,ServiceTool>();
	
	protected ServiceTool createServiceTool(Method method, org.eclipse.ecf.ai.mcp.tools.annotation.Tool toolAnnotation) {
		return new ServiceTool(this.serviceInstance, this.serviceClass, method, toolAnnotation);
	}
	
	public <T> ServiceToolGroup(Object serviceInstance, Class<?> serviceClass) {
		this.serviceClass = serviceClass;
		this.serviceInstance = serviceInstance;
		Arrays.asList(this.serviceClass.getMethods()).stream().map(m -> {
			// skip static methods
			if (!Modifier.isStatic(m.getModifiers())) {
				org.eclipse.ecf.ai.mcp.tools.annotation.Tool ma = m.getAnnotation(org.eclipse.ecf.ai.mcp.tools.annotation.Tool.class);
				return (ma != null) ? createServiceTool(m, ma) : null;
			}
			return null;
		}).filter(Objects::nonNull).collect(Collectors.toList()).forEach(st -> this.serviceToolMap.put(st.getName(), st));
	}
	
	public void addSyncTools(McpSyncServer server) {
		synchronized (this) {
			this.serviceToolMap.forEach((k, t) -> {
				server.addTool(t.buildSyncToolSpecification());
			});
		}
	}
	
	public void dispose() {
		synchronized (this) {
			this.serviceToolMap.forEach((k, t) -> {
				t.dispose();
			});
			this.serviceToolMap.clear();
		}
	}
	
}
