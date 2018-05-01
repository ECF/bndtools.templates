package org.eclipse.ecf.bndtools.templates.remoteservices;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(id = "org.eclipse.ecf.bndtools.templates.remoteservices.async", name = ImplAsyncTemplateMeta.NAME, description = ImplAsyncTemplateMeta.NAME )
public @interface ImplAsyncTemplateMeta {

	public static final String NAME = "Remote Service Async Implementation/Consumer Project Template";
	
	@AttributeDefinition(name = "API Package", description = "The apipackage/plugin name where ExampleAsyncRemoteService interface class exists in workspace.  May be created via the Remote Service API project template.")
	String apipackage() default "org.example.remoteservice.async.api";
}
