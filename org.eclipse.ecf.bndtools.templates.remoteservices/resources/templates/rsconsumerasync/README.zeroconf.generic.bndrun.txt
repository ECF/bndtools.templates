Discovery Note:  The zeroconf discovery uses LAN-based multicast.  If multicast is disabled 
on the LAN, then discovery will not happen.

Distribution Note:   To successfully run the <projectname>.zeroconf.generic.bndrun and export the
ExampleAsyncRemoteService service, the @ExportedService annotation must be modified (in the 
ExampleAsyncRemoteServiceImpl source code) so that the service_exported_configs is set to 
ecf.generic.server.  For example:

@ExportedService(service_exported_interfaces = ExampleRemoteService.class, service_exported_configs = "ecf.generic.server")
public class ExampleAsyncRemoteServiceImpl implements ExampleAsyncRemoteService {
...

