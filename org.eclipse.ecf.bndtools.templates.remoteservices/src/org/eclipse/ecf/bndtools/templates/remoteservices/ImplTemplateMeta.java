package org.eclipse.ecf.bndtools.templates.remoteservices;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(id = "org.eclipse.ecf.bndtools.templates.remoteservices", name = ImplTemplateMeta.NAME, description = ImplTemplateMeta.NAME)
public @interface ImplTemplateMeta {

	public static final String NAME = "Remote Service Project Template";

	@AttributeDefinition(name = "API Package/Project", description = "The package in a previously-created project where the service interface exists.  Must be created prior to creating this project.  A suitable API project can be created via the Remote Service API project template")
	String api__package() default "replace.this.with.your.api.package";

	@AttributeDefinition(name = "Service Exported Config", description = "The service exported config to be used as for the example exported service.   It must identify a distribution provider that will be used for export of the ExampleRemoteServiceImpl")
	String service__exported__config() default "ecf.generic.server";
}
