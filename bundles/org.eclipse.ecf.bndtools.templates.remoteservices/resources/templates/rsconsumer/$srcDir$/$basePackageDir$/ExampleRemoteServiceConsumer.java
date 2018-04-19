package $basePackageName$;

import org.osgi.service.component.annotations.*;
import $apipackage$.ExampleRemoteService;

@Component(immediate=true)
public class ExampleRemoteServiceConsumer {

	@Reference
	ExampleRemoteService service;
	
	@Activate
	void activate() throws Exception {
		System.out.println("service responds="+service.hello("ExampleRemoteServiceConsumer"));
	}
	
}
