package org.eclipse.ecf.bndtools.templates.remoteservices;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(id = "org.eclipse.ecf.bndtools.templates.remoteservices.async", name = ImplAsyncTemplateMeta.NAME, description = ImplAsyncTemplateMeta.NAME )
public @interface ImplAsyncTemplateMeta {

	public static final String NAME = "Remote Service Async Project Template";
	
	@AttributeDefinition(name = "API Package/Project", description = "The package previously created in workspace where ExampleRemoteService service interface exists.  Must be created prior to creating this project.  The API project can be created via the Remote Service API project template")
	String api__package() default "replace.this.with.your.api.package";

	@AttributeDefinition(name = "Service Exported Config", description = "The service exported config to be used as for the example exported service.   It must identify a distribution provider that will be used for export of the ExampleRemoteServiceImpl")
	String service_exported_config() default "ecf.generic.server";
}
