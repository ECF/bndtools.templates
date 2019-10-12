package org.eclipse.ecf.bndtools.templates.remoteservices;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(id = "org.eclipse.ecf.bndtools.templates.remoteservices.consumer", name = ConsumerTemplateMeta.NAME, description = ConsumerTemplateMeta.NAME)
public @interface ConsumerTemplateMeta {

	public static final String NAME = "Remote Service Consumer Project Template";

	@AttributeDefinition(name = "API Package/Project", description = "The package in a previously-created project where the service interface exists.  Must be created prior to creating this project.  A suitable API project can be created via the Remote Service API project template")
	String api__package() default "replace.this.with.your.api.package";

}
