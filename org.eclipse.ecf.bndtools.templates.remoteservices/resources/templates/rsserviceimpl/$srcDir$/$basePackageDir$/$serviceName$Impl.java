package $basePackageName$;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ExportedService;

import $api_package$.$serviceName$Service;

/**
 * An implementation of the $serviceName$Service
 * <p>
 * The Component annotation below gives a value of 20000ms for the
 * osgi.basic.timeout property, which provides remote consumers with a timeout.
 * See <a href=
 * "https://docs.osgi.org/specification/osgi.cmpn/7.0.0/service.remoteservices.html#d0e1389">here</a>
 * for information about the osgi.basic.timeout in the <a href=
 * "https://docs.osgi.org/specification/osgi.cmpn/7.0.0/service.remoteservices.html">Compendium
 * Chapter 100 - Remote Services</a>.
 * </p>
 * <p>
 * The ExportedService annotation below exports this component as a remote
 * service, making it available for import by consumers outside the exporting
 * service process. For details about OSGi Remote Services see <a href=
 * "https://docs.osgi.org/specification/osgi.cmpn/7.0.0/service.remoteservices.html">Compendium
 * Chapter 100 - Remote Services</a> Note that that the provider identified by
 * the service exported config value must be present in the runtime (bndrun
 * file) at the time of service registration for it to be successfully exported.
 * </p>
 */
@Component(property = "osgi.basic.timeout=20000") // Timeout of 20000ms=20s
@ExportedService(service_exported_interfaces = $serviceName$Service.class, service_exported_configs = "ecf.generic.server")
public class $serviceName$Impl implements $serviceName$Service {

	public String callsync(String name) {
		return "callsync greetings to " + name;
	}
	
}

//For complete list of available distribution providers and their associated OSGi service exported config 
//value see: https://wiki.eclipse.org/Distribution_Providers
