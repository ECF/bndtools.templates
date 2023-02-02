package org.eclipse.ecf.bndtools.templates.remoteservices;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(id = "org.eclipse.ecf.bndtools.templates.remoteservices.async", name = ImplAsyncTemplateMeta.NAME, description = ImplAsyncTemplateMeta.NAME )
public @interface ImplAsyncTemplateMeta {

	public static final String NAME = "Async Remote Service Project Template";
	
	@AttributeDefinition(name = "API Package/Project", description = "Previously-created API Package/Project. A project can be created via the Async Remote Service API template")
	String api__package() default "<your.api.package.here>";

	@AttributeDefinition(name = "Service Exported Config", description = "The service exported config identifying the distribution provider for export")
	String service__exported__config() default "ecf.generic.server";
}
