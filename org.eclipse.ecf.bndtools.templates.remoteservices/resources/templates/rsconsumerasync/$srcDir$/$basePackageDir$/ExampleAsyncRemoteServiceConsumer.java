package $basePackageName$;

import org.osgi.service.component.annotations.*;
import $apipackage$.ExampleAsyncRemoteService;

@Component(immediate=true)
public class ExampleAsyncRemoteServiceConsumer {

	@Reference
	ExampleAsyncRemoteService service;

	@Activate
	void activate() throws Exception {
		service.hello("ExampleAsyncRemoteServiceConsumer").whenComplete((result,exception) -> {
			if (exception != null)
				exception.printStackTrace();
			else 
				System.out.println("service responds="+result);
		});
	}
}
