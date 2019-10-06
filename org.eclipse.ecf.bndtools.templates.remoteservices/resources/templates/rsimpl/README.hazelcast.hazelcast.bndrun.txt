Note:   To successfully run the <projectname>.hazelcast.hazelcast.bndrun and export the
ExampleAsyncRemoteService service, the @ExportedService annotation must be modified (in the 
ExampleAsyncRemoteServiceImpl source code) so that the service_exported_configs is set to 
ecf.jms.hazelcast.manager.  For example:

@ExportedService(service_exported_interfaces = ExampleRemoteService.class, service_exported_configs = "ecf.jms.hazelcast.manager")
public class ExampleAsyncRemoteServiceImpl implements ExampleAsyncRemoteService {
...

