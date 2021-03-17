Discovery Notes:  Etcd discovery requires running an etcd server.   By default, 
this bndrun is configured to used a v2 etcd server running on localhost.
The etcd server host may be set via a system property in the bndrun file:

-Decf.discovery.etcd.hostname=localhost

Note that when starting the etcd server the following v2 option should be set:  etcd --enable-v2="true"

All the Etcd discovery properties are specified here:  https://wiki.eclipse.org/Etcd-Based_Discovery_Provider

The Etcd discovery provider implementation is here:  https://github.com/ECF/etcd-provider

Distribution Note:   To successfully run the <projectname>.zeroconf.generic.bndrun and export the
ExampleAsyncRemoteService service, the @ExportedService annotation must be modified (in the 
ExampleAsyncRemoteServiceImpl source code) so that the service_exported_configs is set to 
ecf.generic.server.  For example:

@ExportedService(service_exported_interfaces = ExampleRemoteService.class, service_exported_configs = "ecf.generic.server")
public class ExampleAsyncRemoteServiceImpl implements ExampleAsyncRemoteService {
...

