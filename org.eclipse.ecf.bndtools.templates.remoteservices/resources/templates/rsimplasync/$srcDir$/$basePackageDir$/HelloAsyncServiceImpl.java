package $basePackageName$;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ExportedService;

import java.util.concurrent.CompletableFuture;

import $api_package$.HelloAsyncService;

@Component(property = "osgi.basic.timeout=10000") // Timeout of 10s=10000ms
//The following will export using the ecf.generic.server distribution provider
@ExportedService(service_exported_interfaces = HelloAsyncService.class, 
service_exported_configs = "ecf.generic.server", 
service_exported_intents = { "osgi.basic", "osgi.async" })
//Note that that the provider identified by the service exported config value must be
//present in the runtime (bndrun) at the time of service registration for it to be
//exported
public class HelloAsyncServiceImpl implements HelloAsyncService {

  public CompletableFuture<String> hello(String from) {
      System.out.println("HelloAsyncServiceImpl.hello called from="+from);
      CompletableFuture<String> cf = new CompletableFuture<String>();
      cf.complete("Hello "+from);
      return cf;
  }

}

//Examples for use of other distribution providers.  
//For complete list of available providers and their associated OSGi service exported config 
//value see: https://wiki.eclipse.org/Distribution_Providers
//
//r-osgi: ecf.r_osgi.peer documentation: https://wiki.eclipse.org/Distribution_Providers#r-OSGi_Provider
//@ExportedService(service_exported_interfaces = ExampleRemoteService.class, service_exported_configs = "ecf.r_osgi.peer")
//Hazelcast: ecf.jms.hazelcast.manager full documentation: https://wiki.eclipse.org/Distribution_Providers#Hazelcast_Provider
//@ExportedService(service_exported_interfaces = ExampleRemoteService.class, service_exported_configs = "ecf.jms.hazelcast.manager")
//To use other provider replace the @ExportedService line above ExampleRemoteServiceImpl with the
//desired distribution provider service exported config value.
//For a list of ECF distribution providers and their associated exported config id see:  
//https://wiki.eclipse.org/Distribution_Providers