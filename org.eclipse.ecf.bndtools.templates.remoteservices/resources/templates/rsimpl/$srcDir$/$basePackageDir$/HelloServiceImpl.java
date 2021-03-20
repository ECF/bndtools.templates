package $basePackageName$;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ExportedService;

import $api_package$.HelloService;

@Component
//The following will export using the ecf.generic.server distribution provider
@ExportedService(service_exported_interfaces = HelloService.class, service_exported_configs = "$service_exported_config$")
//Note that that the provider identified by the service exported config value must be
//present in the runtime (bndrun) at the time of service registration for it to be
//exported
public class HelloServiceImpl implements HelloService {

	public String hello(String name) {
		return "Hello Sync to " + name;
	}
	
}

//For complete list of available distribution providers and their associated OSGi service exported config 
//value see: https://wiki.eclipse.org/Distribution_Providers
