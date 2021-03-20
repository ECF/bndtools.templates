package $basePackageName$;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ExportedService;

import java.util.concurrent.CompletableFuture;

import $api_package$.HelloAsyncService;

@Component(property = "osgi.basic.timeout=20000") // Timeout of 20000ms=20s
//The following will export using the ecf.generic.server distribution provider
@ExportedService(service_exported_interfaces = HelloAsyncService.class, service_exported_configs = "ecf.generic.server", service_exported_intents = {
		"osgi.basic", "osgi.async" })
//Note that that the provider identified by the service exported config value must be
//present in the runtime (bndrun) at the time of service registration for it to be
//exported
public class HelloAsyncServiceImpl implements HelloAsyncService {

	public CompletableFuture<String> hello(String from) {
		CompletableFuture<String> cf = new CompletableFuture<String>();
		cf.complete("Hello Async To " + from);
		return cf;
	}

}

//For complete list of available distribution providers and their associated OSGi service exported config 
//value see: https://wiki.eclipse.org/Distribution_Providers
