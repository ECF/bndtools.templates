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
		return "Hello " + name;
	}

}

//Examples for use of other distribution providers.  
//For complete list of available providers and their associated OSGi service exported config 
// value see: https://wiki.eclipse.org/Distribution_Providers
//
//r-osgi: ecf.r_osgi.peer documentation: https://wiki.eclipse.org/Distribution_Providers#r-OSGi_Provider
//@ExportedService(service_exported_interfaces = ExampleRemoteService.class, service_exported_configs = "ecf.r_osgi.peer")
//Hazelcast: ecf.jms.hazelcast.manager full documentation: https://wiki.eclipse.org/Distribution_Providers#Hazelcast_Provider
//@ExportedService(service_exported_interfaces = ExampleRemoteService.class, service_exported_configs = "ecf.jms.hazelcast.manager")
//To use other provider replace the @ExportedService line above ExampleRemoteServiceImpl with the
//desired distribution provider service exported config value.
// For a list of ECF distribution providers and their associated exported config id see:  
// https://wiki.eclipse.org/Distribution_Providers