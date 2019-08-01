package $basePackageName$;

import org.osgi.service.component.annotations.*;
import $apipackage$.HelloWorldService;

@Component(immediate = true)
public class HelloWorldServiceConsumer {

	@Reference
	HelloWorldService service;

	@Activate
	void activate() throws Exception {
		System.out.println("HelloWorldService.getMessage() responds=" + service.getMessage());
	}

}
