package $basePackageName$;

import org.osgi.service.component.annotations.*;
import $api_package$.HelloWorldService;

@Component(immediate = true)
public class HelloWorldServiceConsumer {

	@Reference
	HelloWorldService service;

	@Activate
	void activate() throws Exception {
		System.out.println("HelloWorldService.getMessage() responds=" + service.getMessage());
	}

}
