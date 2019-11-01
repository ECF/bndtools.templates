package org.eclipse.ecf.bndtools.templates.remoteservices;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(id = "org.eclipse.ecf.bndtools.templates.remoteservices.host", name = HostTemplateMeta.NAME, description = HostTemplateMeta.NAME)
public @interface HostTemplateMeta {

	public static final String NAME = "Remote Service Host Project Template";

	@AttributeDefinition(name = "API Package/Project", description = "Previously-created API Package/Project. A project can be created via the JaxRS Remote Service API template")
	String api__package() default "replace.this.with.your.api.package";

}
