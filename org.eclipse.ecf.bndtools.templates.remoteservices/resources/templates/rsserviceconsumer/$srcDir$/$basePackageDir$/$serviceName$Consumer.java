package $basePackageName$;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.apache.felix.service.command.annotations.GogoCommand;
import $api_package$.$serviceName$Service;

@Component(service = $serviceName$Consumer.class)
@GogoCommand(scope = "$serviceName$Consumer", function = "callsync")
public class $serviceName$Consumer {

	private volatile $serviceName$Service service;

	@Reference(policy = ReferencePolicy.DYNAMIC)
	void bindService($serviceName$Service svc) {
		this.service = svc;
		System.out.println(
				"Async remote service consumer activated.  Console command 'callasync <name>' may now be used");
	}

	void unbindService($serviceName$Service svc) {
		this.service = null;
	}

	public String callsync(String name) {
		return service.callsync(name);
	}

}
