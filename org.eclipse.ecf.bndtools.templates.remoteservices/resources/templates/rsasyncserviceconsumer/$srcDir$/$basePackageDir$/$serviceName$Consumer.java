package $basePackageName$;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.apache.felix.service.command.annotations.GogoCommand;
import $api_package$.$serviceName$Service;

/**
 * An example consumer of the $serviceName$Service. With both the Component and
 * GogoCommand annotation, when the Reference $serviceName$Service is imported
 * and this component is activated, the 'callasync' method is then made
 * available as a console command. With this console command consumers may then
 * invoke the remote service by giving the console command:
 * 
 * <pre>
 * osgi> callasync MyName
 * </pre>
 * 
 * As can be seen by the implementation of the {@link #callasync(String)} method
 * below, the remote service method is then invoked asynchronously
 */
@Component(service = $serviceName$Consumer.class, immediate = true)
@GogoCommand(scope = "$serviceName$Consumer", function = "callasync")
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

	public void callasync(String from) {
		// cal asynchrous remote service method
		service.callasync(from).whenComplete((result, exception) -> {
			if (exception != null) {
				System.out.println("$serviceName$Service exception");
				exception.printStackTrace();
			} else {
				System.out.println("$serviceName$Service responds: " + result);
			}
		});
	}

}
