package $basePackageName$;

import org.osgi.service.component.annotations.*;
import $apipackage$.ExampleRemoteService;

@Component(property = { "service.exported.interfaces=*", 
                        "service.intents=osgi.basic" })
public class ExampleRemoteServiceImpl implements ExampleRemoteService {

    public String hello(String name) {
        System.out.println("ExampleRemoteServiceImpl.hello called with name="+name);
        return "Hello "+name;
    }
            
}
