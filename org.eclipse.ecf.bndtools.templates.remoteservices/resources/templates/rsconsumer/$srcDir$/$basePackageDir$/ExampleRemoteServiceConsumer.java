package $basePackageName$;

import org.osgi.service.component.annotations.*;
import $api_package$.ExampleRemoteService;

@Component(immediate=true)
public class ExampleRemoteServiceConsumer {

	@Reference
	ExampleRemoteService service;
	
	@Activate
	void activate() throws Exception {
		System.out.println("service responds="+service.hello("ExampleRemoteServiceConsumer"));
	}
	
}
