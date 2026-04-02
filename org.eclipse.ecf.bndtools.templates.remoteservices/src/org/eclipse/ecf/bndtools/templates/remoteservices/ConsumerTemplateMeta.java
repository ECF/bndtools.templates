package org.eclipse.ecf.bndtools.templates.remoteservices;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(id = "org.eclipse.ecf.bndtools.templates.remoteservices.consumer", name = ConsumerTemplateMeta.NAME, description = ConsumerTemplateMeta.NAME)
public @interface ConsumerTemplateMeta {

	public static final String NAME = "Remote Service Sync Consumer Project Template";

	@AttributeDefinition(name = "API Project", description = "To create a new API project: File->New->Bnd OSGi Project and select appropriate API project template")
	String api__package() default "<your.api.project.name.here>";

}
