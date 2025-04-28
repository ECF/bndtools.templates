# README for Bndtools Python.Java Example

This example shows service-level interaction between Java implemented components
(i.e. Python consuming Java exported services...Python->Java), and Python-implemented components  consumed by Java components (Java->Python) via the ECF Python.Java/Py4j remote services distribution provider.

## Running With Bndtools bndrun

To run, start, export the Java examples services, open the [$projectName$.hellopython.javahost.bndrun](./$projectName$.hellopython.javahost.bndrun) file in this project, click
Resolve->Update under the Run Requirements, and choose Run OSGi or Debug OSGi.

### Running Python Example 

To run the example python program named run_python_example.py a version of Python 3.9 or newer has to be
installed, and you must have previously installed iPOPO v 3.1.0 or newer.  To install iPOPO using pip:

```
pip install iPOPO >=3.1.0
```

To run the run_python_example.py (NOTE: The Java process must be started as per Running Java in Bndtools above
BEFORE running the python example, as the python example attempts to connect to the Java process when run

```
python run_python_example.py
```

Both the Java process and the Python process produce output to the console.  In Bndtools/Eclipse breakpoints can
be set if run as Debug OSGi.

## Python.Java and Java.Python Services

This example implements/exports 2 OSGi Remote Services via the [OSGi Remote Service Admin Specification](https://docs.osgi.org/specification/osgi.cmpn/7.0.0/service.remoteserviceadmin.html), and 
imports/consumes a Python service implementation included as [pbhelloimpl.py](./python-src/samples/rsa/pbhelloimpl.py).  This means (among other things) that the metadata used
to describe remote services (called EndpointDescriptions in the specification) are open
standardized, cross-vendor, and supports cross-language (e.g. Java/Python) runtimes.

Below is a short description of each of these services.

## Java/OSGi Remote Services

### [HelloImpl](./$srcDir$/$basePackageDir$/hello/HelloImpl.java)

The HelloImpl class implements a Java-side [IHello interface](https://github.com/ECF/Py4j-RemoteServicesProvider/blob/master/examples/org.eclipse.ecf.examples.hello/src/org/eclipse/ecf/examples/hello/IHello.java). When activated, it will be exposed as an OSGi Remote Service to Python consumers.

### [ProtobufHelloImpl](./$srcDir$/$basePackageDir$/hello/ProtobufHelloImpl.java)

The ProtobufHelloImpl class implements a Java-side [IHello interface](https://github.com/ECF/Py4j-RemoteServicesProvider/blob/master/examples/org.eclipse.ecf.examples.protobuf.hello/src/org/eclipse/ecf/examples/protobuf/hello/IHello.java). It uses Google Protobuf-generated (Java) Messages for IHello method arguments and return
values. When activated, it will be exposed as an OSGi Remote Service to Python consumers.

## Python/iPOPO Remote Services

### [PbHelloImpl](./python-src/samples/rsa/pbhelloimpl.py)

The python implementation of the protobuf IHello service. It uses Google Protobuf compiler-created (python) Messages (as does the for IHello method arguments and return
values. When activated, it will be exposed as an OSGi Remote Service exposed to Python consumers.
