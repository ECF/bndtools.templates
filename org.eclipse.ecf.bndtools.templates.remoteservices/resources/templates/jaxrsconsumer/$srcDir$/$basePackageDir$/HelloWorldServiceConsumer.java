package $basePackageName$;

import java.util.concurrent.CompletableFuture;

import org.osgi.service.component.annotations.*;
import $api_package$.HelloWorldService;

@Component(immediate = true)
public class HelloWorldServiceConsumer {

	// target = (service.imported=*) guarantees that it's a remote service that gets injected
	@Reference(target = "(service.imported=*)")
	HelloWorldService service;

	@Activate
	void activate() throws Exception {
		System.out.println("HelloWorldServiceConsumer.activate called");
		// this getMessage call is blocking
		// this getMessageAsync call in not blocking
		System.out.println("HelloWorldService.getMessage() responds=" + service.getMessage("HelloWorldServiceConsumer says Hi via getMessage"));
		CompletableFuture<String> cf = service.getMessageAsync("HelloWorldServiceConsumer says Hi via getMessageAsync");
		cf.whenComplete((r,e) -> {
				if (e != null) {
					e.printStackTrace();
				} else {
					System.out.println("HelloWorldService.getMessageAsync responds=" + r);
				}});
		System.out.println("HelloWorldServiceConsumer.activate ended");
	}

}
