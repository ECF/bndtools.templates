package org.eclipse.ecf.bndtools.templates.remoteservices;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(id = "org.eclipse.ecf.bndtools.templates.remoteservices.async.consumer", name = ConsumerAsyncTemplateMeta.NAME, description = ConsumerAsyncTemplateMeta.NAME )
public @interface ConsumerAsyncTemplateMeta {

	public static final String NAME = "Remote Service Consumer Project Template";
	
	@AttributeDefinition(name = "API Package/Project", description = "Previously-created API Package/Project. A project can be created via one of the API project templates")
	String api__package() default "<your.api.package.here>";

}
