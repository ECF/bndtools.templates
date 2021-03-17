Discovery Note:  The Hazelcast discovery uses LAN-based multicast.  If multicast is disabled 
on the LAN, then the default Hazelcast discovery config will not happen.  For more information
about Hazelcast discovery configuration see https://wiki.eclipse.org/Hazelcast-Based_Discovery_Provider

Note:  To successfully run the <projectname>.hazelcast.dubbo.bndrun and export the
ExampleRemoteService service, the @ExportedService annotation must be modified (in the 
ExampleRemoteServiceImpl source code) so that the service_exported_configs is set to 
ecf.dubbo.server.  For example:

@ExportedService(service_exported_interfaces = ExampleRemoteService.class, service_exported_configs = "ecf.dubbo.server")
public class ExampleAsyncRemoteServiceImpl implements ExampleAsyncRemoteService {
...

