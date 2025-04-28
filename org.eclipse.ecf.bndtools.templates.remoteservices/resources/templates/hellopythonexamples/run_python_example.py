print("NOTE: Running this program successfully has two requirements")
print("")
print("  1) Installing (via pip or other) iPOPO version >= 3.1.0 in your python ")
print("     installation")
print("")
print("  2) Running a localhost instance of the app represented by the bndrun file ")
print("     named $projectName$.hellopython.javahost.bndrun in this directory.")
print("     To start an instance with Bndtools, open the $projectName$.hellopython.javahost.bndrun,") 
print("     click on Resolve, Update, and then click on Run or Debug")
print("")
import pelix.framework as pelix

JAVA_PORT = 25333 # these values are the default configuration for the Java side
PYTHON_PORT = 25334
USE_IMPORT_HOOK = True

from pelix.framework import BundleContext

def install_and_start(context: BundleContext, name: str):
    bundle = context.install_bundle(name)
    bundle.start()
    return bundle

def main() -> None:
    # Set the initial bundles
    bundles = (
        "pelix.ipopo.core",
        "pelix.shell.core",
        "pelix.shell.ipopo",
        "pelix.shell.console",
        # RSA implementation
        "pelix.rsa.remoteserviceadmin",
        # Basic topology manager
        "pelix.rsa.topologymanagers.basic",
        # RSA shell commands 
        "pelix.rsa.shell",
        # This provides the communications support that connects to the Java server
        "pelix.rsa.providers.distribution.py4j"
    )
    framework = pelix.create_framework(
        bundles, {"ecf.py4j.javaport": JAVA_PORT, 
                  "ecf.py4j.pythonport": PYTHON_PORT, 
                  "ecf.py4j.useimporthook": USE_IMPORT_HOOK}
    )
    # The framework.start() will trigger the pelix.rsa.providers.distribution.py4j
    # distribution provider to connect to 25333 and expect a back conneection on 25334
    framework.start()
    
    context = framework.get_bundle_context()
    
    # Assuming no exceptions in start, we should now be connected to the 
    # java python.java service. 
    # RSA requires a topology manager.  This provides a default 
    # for RSA docs see:https://docs.osgi.org/specification/osgi.enterprise/7.0.0/service.remoteserviceadmin.html
    from pelix.rsa.topologymanagers.basic import instantiate_basic_topology_manager
    instantiate_basic_topology_manager(context)
    
    print("pelix started and connected to java server at port={}".format(25333))
    print("")
    from time import sleep
    print("Waiting a few seconds before starting the first consumer...")
    sleep(3)
    print("Starting the IHello remote service consumer")
    # start the hello consumer.  This should trigger communication with 
    # java-side remote service implementing the org.eclipse.ecf.examples.hello.IHello
    # java interface. See the samples.rsa.helloconsumer module for example code
    install_and_start(context, "samples.rsa.helloconsumer")
    # wait for responses
    print("")
    print("Waiting 5 seconds")
    sleep(5)
    print("")
    print("Starting the protobuf IHello remote service consumer...")
    # install the protobuf (pb) hello consumer.  This install should trigger communication with 
    # java-side remote service implementing the org.eclipse.ecf.examples.protobuf.hello.IHello
    # java interface.  See the samples.rsa.pbhelloconsumer module for the example code 
    install_and_start(context, "samples.rsa.pbhelloconsumer")
    print("")
    print("Waiting 5 seconds")
    sleep(5)
    
    print("")
    print("Starting the python IHello remote service implementation...")   
    print("") 
    # install the protobuf hello implementation.  This should trigger communication with 
    # java-side consumer.  This impl implements the org.eclipse.ecf.examples.protobuf.hello.IHello
    # java interface interface.  See the samples.rsa.pbhelloimpl module for the example code 
    install_and_start(context, "samples.rsa.pbhelloimpl")
    print("")
    print("Waiting 5 seconds")
    sleep(5)
    print("")
    print("The import in the code below: 'from foo.bar.baz import Bar' will be resolved by the Java class")
    print("PythonFooModuleResolver, which points to /python-src inside the ")
    print("built jar")
    print("")
    from foo.bar.baz import Bar
    print("")
    print("...import fromfoo.bar.baz import Bar completed")
    print("...creating an instance of Bar...")
    print("")
    b = Bar()
    print("")
    print("...Bar instance created={}".format(b))
    print("")
    print("To stop pelix framework type: stop 0 at console prompt")
    try:
        framework.wait_for_stop()
    except KeyboardInterrupt:
        framework.stop()
    
if __name__ == '__main__':
    main()
    
