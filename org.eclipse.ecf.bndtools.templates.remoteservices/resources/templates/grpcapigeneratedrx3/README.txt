README for gRPC Remote Services API Project

The project has a single proto file (in protofiles/health.proto) that defines a 'HealthCheck' service
using protocol buffers service declaration.   This example HealthCheck service is then used to generate 
java source code and classes necessary to declare an OSGi Remote Service.  This generated source code 
includes a service interface (HealthCheckService) and supporting classes (such as protobuf message classes,
and support classes for using reactivex v3 APIs for asynchronous and streaming support.

See health.proto for the grpc HealthCheck service declaration.  

See here https://github.com/ECF/bndtools.grpc for a description of the bndtools code generation behavior
done by the bndtools -generate command, which appears here in the project bnd.bnd:

-generate \
	protofiles; \
		output=src/main/java; \
		generate='org.eclipse.ecf.bndtools.grpc.GrpcGenerator rxjava3 -I=protofiles --java_out=src/main/java health.proto 2>protoc.errors'

When the project is created using this template, it should result in the java service interface and support
classes being generated to src/main/java and then automatically compiled and turned into an OSGi bundle
by bndtools+eclipse.