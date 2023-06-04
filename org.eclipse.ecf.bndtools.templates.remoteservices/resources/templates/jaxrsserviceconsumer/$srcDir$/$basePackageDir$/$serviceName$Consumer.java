package $basePackageName$;

import java.util.concurrent.CompletableFuture;

import org.osgi.service.component.annotations.*;
import $api_package$.$serviceName$Service;

@Component(immediate = true)
public class $serviceName$Consumer {

	// target = (service.imported=*) guarantees that it's a remote service that gets injected
	@Reference(target = "(service.imported=*)")
	$serviceName$Service service;

	@Activate
	void activate() throws Exception {
		System.out.println("$serviceName$Consumer.activate called");
		// this getMessage call is blocking
		System.out.println("$serviceName$Service.getMessage() responds="
				+ service.getMessage("$serviceName$Consumer says Hi via getMessage"));
		service.getMessageAsync("$serviceName$Consumer says Hi via getMessageAsync").whenComplete((r, e) -> {
			if (e != null) {
				e.printStackTrace();
			} else {
				System.out.println("$serviceName$Service.getMessageAsync responds=" + r);
			}
		});
		System.out.println("$serviceName$Consumer.activate ended");
	}

}
