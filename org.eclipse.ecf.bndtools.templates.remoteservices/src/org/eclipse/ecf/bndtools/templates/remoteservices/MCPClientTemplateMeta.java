package org.eclipse.ecf.bndtools.templates.remoteservices;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(id = "org.eclipse.ecf.bndtools.templates.remoteservices.mcpclient", name = MCPClientTemplateMeta.NAME, description = MCPClientTemplateMeta.NAME)
public @interface MCPClientTemplateMeta {

	public static final String NAME = "MCP ArithmeticTools Test Client Project Template";

	@AttributeDefinition(name = "MCP ArithmeticTools API Package/Project", description = "Previously-created ArithmeticTools API Package/Project in workspace. If it does not yet exist in workspace, it can be created with File->New->Bnd OSGi Project->MCP ArithmeticTools API template")
	String api__package() default "<your.api.package.here>";

	@AttributeDefinition(name = "MCP Server Project Name", description = "Previously-created MCP Server/ArithmeticTools Impl. If it does not yet exist in workspace, it can be created with File->New->Bnd OSGi Project->MCP Server/ArithmeticTools Consumer template")
	String mcp__server__project() default "<your.workspace.mcp.server.project.name>";

}
