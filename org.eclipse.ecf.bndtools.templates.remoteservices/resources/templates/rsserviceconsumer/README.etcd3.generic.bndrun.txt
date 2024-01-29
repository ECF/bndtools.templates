README for etcd3 discovery and generic distribution Bnd Run File

Requirements:  etcd3 discovery requires a running etcd3 server.  Please see https://etcd.io/ 
for instructions for installing, configuring and running an etcd3 server.

These system properties are set in the <projectName>.etcd3.grpc.bndrun file:

-runvm: -Decf.discovery.etcd3.usePlaintext=true\n\
	-Decf.discovery.etcd3.hostname=localhost\n\
	-Decf.discovery.etcd3.port=2379

These properties set the target etcd3 server hostname to 'localhost', port to 2379 (etcd default), and uses 'plaintext' rather than
encrypted communication for testing.  The hostname and property values should be updated
as appropriate to the network environment for the etcd3 server being used.

See README.txt for the steps for starting zeroconf Bnd Run File config.