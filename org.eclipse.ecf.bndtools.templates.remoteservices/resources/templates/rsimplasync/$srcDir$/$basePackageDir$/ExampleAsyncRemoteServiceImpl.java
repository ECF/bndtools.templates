package $basePackageName$;

import org.osgi.service.component.annotations.*;

import java.util.concurrent.CompletableFuture;

import $apipackage$.ExampleAsyncRemoteService;

@Component(property = { "service.exported.interfaces=*", "service.exported.intents=osgi.basic",
		"service.exported.intents=osgi.async" })
public class ExampleAsyncRemoteServiceImpl implements ExampleAsyncRemoteService {

    public CompletableFuture<String> hello(String from) {
        System.out.println("ExampleRemoteServiceImpl.hello called from="+from);
        CompletableFuture<String> cf = new CompletableFuture<String>();
        cf.complete("Hello "+from);
        return cf;
    }

}
