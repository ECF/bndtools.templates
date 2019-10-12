package org.eclipse.ecf.bndtools.templates.remoteservices;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(id = "org.eclipse.ecf.bndtools.templates.remoteservices.async.host", name = HostAsyncTemplateMeta.NAME, description = HostAsyncTemplateMeta.NAME )
public @interface HostAsyncTemplateMeta {

	public static final String NAME = "Remote Service Async Host Project Template";
	
	@AttributeDefinition(name = "API Package/Project", description = "The package previously created in workspace where ExampleRemoteService service interface exists.  Must be created prior to creating this project.  The API project can be created via the Remote Service API project template")
	String api__package() default "replace.this.with.your.api.package";

}
