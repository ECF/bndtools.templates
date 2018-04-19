package org.eclipse.ecf.bndtools.templates.remoteservices;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(id = "org.eclipse.ecf.bndtools.templates.remoteservices", name = ImplTemplateMeta.NAME, description = ImplTemplateMeta.NAME )
public @interface ImplTemplateMeta {

	public static final String NAME = "Remote Service Implementation/Consumer Project Template";
	
	@AttributeDefinition(name = "API Package", description = "The apipackage/plugin name where ExampleRemoteService interface class exists in workspace.  May be created via the Remote Service API project template.")
	String apipackage() default "org.example.remoteservice.api";
}
