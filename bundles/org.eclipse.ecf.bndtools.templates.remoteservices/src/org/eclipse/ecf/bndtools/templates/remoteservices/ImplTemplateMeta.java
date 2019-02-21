package org.eclipse.ecf.bndtools.templates.remoteservices;

@ObjectClassDefinition(id = "org.eclipse.ecf.bndtools.templates.remoteservices", name = ImplTemplateMeta.NAME, description = ImplTemplateMeta.NAME )
public @interface ImplTemplateMeta {

	public static final String NAME = "Remote Service Project Template";
	
	@AttributeDefinition(name = "API Package", description = "The package in workspace where ExampleRemoteService interface has been declared.  May be created via the Remote Service API project template.")
	String apipackage() default "your.api.package.here";
}
