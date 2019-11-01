Discovery Note:  The zeroconf discovery uses LAN-based multicast.  If multicast is disabled 
on the LAN, then discovery will not happen.

Distribution Note:   To successfully run the <projectname>.zeroconf.rosgi.bndrun and export the
ExampleAsyncRemoteService service, the @ExportedService annotation must be modified (in the 
ExampleAsyncRemoteServiceImpl source code) so that the service_exported_configs is set to 
ecf.r_osgi.peer.  For example:

@ExportedService(service_exported_interfaces = ExampleRemoteService.class, service_exported_configs = "ecf.r_osgi.peer")
public class ExampleAsyncRemoteServiceImpl implements ExampleAsyncRemoteService {
...

