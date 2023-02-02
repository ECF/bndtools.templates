package org.eclipse.ecf.bndtools.templates.remoteservices;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(id = "org.eclipse.ecf.bndtools.templates.remoteservices", name = ImplTemplateMeta.NAME, description = ImplTemplateMeta.NAME)
public @interface ImplTemplateMeta {

	public static final String NAME = "Remote Service Project Template";

	@AttributeDefinition(name = "API Package/Project", description = "Previously-created API Package/Project. A project can be created via the Remote Service API template")
	String api__package() default "<your.api.package.here>";

	@AttributeDefinition(name = "Service Exported Config", description = "The service exported config identifying the distribution provider for export")
	String service__exported__config() default "ecf.generic.server";
}
