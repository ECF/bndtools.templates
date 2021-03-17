package $basePackageName$;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import org.apache.felix.service.command.annotations.GogoCommand;
import $api_package$.HelloAsyncService;

@Component(service=HelloAsyncServiceConsumer.class)
@GogoCommand(scope="consumer", function="helloasync")
public class HelloAsyncServiceConsumer {

	private HelloAsyncService helloService;

	@Activate
	public HelloAsyncServiceConsumer(@Reference HelloAsyncService helloService) {
		this.helloService = helloService;
	}

	public void helloasync(String from) {
		helloService.hello(from).whenComplete((result,exception) -> {
			if (exception != null)
				exception.printStackTrace();
			else 
				System.out.println("helloasync service responds: "+result);
		});
	}
	
}


