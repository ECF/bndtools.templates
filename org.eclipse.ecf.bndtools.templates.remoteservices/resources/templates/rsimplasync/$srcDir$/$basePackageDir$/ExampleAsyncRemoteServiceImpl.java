package $basePackageName$;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ExportedService;

import java.util.concurrent.CompletableFuture;

import $apipackage$.ExampleAsyncRemoteService;

//Class is a component, registered immediately as ExampleRemoteService
@Component(immediate=true, service = ExampleRemoteService.class)
//The following ExportedService annotation will export service using 
//any/all distribution providers available in runtime
@ExportedService(service_exported_interfaces = ExampleRemoteService.class)
//Alternatively, a service may be exported using only a specified distribution provider
//given by the service.exported.configs standard remote service property value.
//The following will export using the ecf.generic.server distribution provider
//@ExportedService(service_exported_interfaces = ExampleRemoteService.class, service_exported_configs = "ecf.generic.server")
//Note that that the provider identified by the service exported config value must be
//present in the runtime at the time of service registration
//See additional examples and documentation for use of other providers below
public class ExampleAsyncRemoteServiceImpl implements ExampleAsyncRemoteService {

    public CompletableFuture<String> hello(String from) {
        System.out.println("ExampleRemoteServiceImpl.hello called from="+from);
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