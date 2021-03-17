package $basePackageName$;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import org.apache.felix.service.command.annotations.GogoCommand;
import $api_package$.HelloService;

@Component(service=HelloServiceConsumer.class)
@GogoCommand(scope="consumer", function="hello")
public class HelloServiceConsumer {

	private HelloService hello;

	@Activate
	public HelloServiceConsumer(@Reference HelloService hello) {
		this.hello = hello;
	}

	public String hello( String name) {
		return hello.hello(name);
	}
	
}
