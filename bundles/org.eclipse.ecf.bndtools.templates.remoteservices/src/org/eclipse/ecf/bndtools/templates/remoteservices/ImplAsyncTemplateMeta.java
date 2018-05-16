package org.eclipse.ecf.bndtools.templates.remoteservices;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(id = "org.eclipse.ecf.bndtools.templates.remoteservices.async", name = ImplAsyncTemplateMeta.NAME, description = ImplAsyncTemplateMeta.NAME )
public @interface ImplAsyncTemplateMeta {

	public static final String NAME = "Remote Service Async Project Template";
	
	@AttributeDefinition(name = "API Package", description = "The package in workspace where ExampleAsyncRemoteService interface class has been declared.  May be created via the Async Remote Service API project template.")
	String apipackage() default "your.api.package.here";
}
