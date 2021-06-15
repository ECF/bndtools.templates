Discovery Note:  etcd3 discovery requires an etcd3 server.  The software to run an etcd3 server
is available from:  https://etcd.io/ .

Note that these system properties are set in the <projectName>.etcd3.grpc.bndrun file:

-runvm: -Decf.discovery.etcd3.usePlaintext=true\n\
	-Decf.discovery.etcd3.hostname=localhost\n\
	-Decf.discovery.etcd3.port=2379

These properties set the target etcd3 server hostname to 'localhost', port to 2379 (etcd default), and uses 'plaintext' rather than
encrypted communication for testing.  These can/should be changed as appropriate to the network environment for the
etcd server being used.

