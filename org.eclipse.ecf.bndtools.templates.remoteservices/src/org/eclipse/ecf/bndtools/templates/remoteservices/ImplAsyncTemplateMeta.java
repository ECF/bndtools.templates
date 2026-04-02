package org.eclipse.ecf.bndtools.templates.remoteservices;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(id = "org.eclipse.ecf.bndtools.templates.remoteservices.async", name = ImplAsyncTemplateMeta.NAME, description = ImplAsyncTemplateMeta.NAME )
public @interface ImplAsyncTemplateMeta {

	public static final String NAME = "Async Remote Service Project Template";
	
	@AttributeDefinition(name = "API Project", description = "To create a new API project: File->New->Bnd OSGi Project and select appropriate API project template")
	String api__package() default "<your.api.project.name.here>";

	@AttributeDefinition(name = "Service Exported Config", description = "The service.exported.config value identifying the distribution provider for service export")
	String service__exported__config() default "ecf.generic.server";
}
