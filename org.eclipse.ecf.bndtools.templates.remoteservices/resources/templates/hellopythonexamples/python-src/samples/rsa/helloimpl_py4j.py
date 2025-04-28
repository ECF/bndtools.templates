#!/usr/bin/python3

# original version of this program available as part of iPOPO project
# at https://github.com/tcalmant/ipopo

from pelix.ipopo.decorators import ComponentFactory, Instantiate, Provides
from samples.rsa.helloimpl import HelloImpl


@ComponentFactory("helloimpl-py4j-factory")
# Provides IHello interface as specified by Java interface.
@Provides("org.eclipse.ecf.examples.hello.IHello")
# See https://github.com/ECF/Py4j-RemoteServicesProvider/blob/master/examples/org.eclipse.ecf.examples.hello/src/org/eclipse/ecf/examples/hello/IHello.java
@Instantiate(
    "helloimpl-py4j",
    {
        "service.exported.interfaces": "*",  # Required for export
        # Required to use py4j python provider for export
        "service.exported.configs": "ecf.py4j.host.python",
        # Required to use osgi.async intent
        "service.intents": ["osgi.async"],
        "osgi.basic.timeout": 30000,
    },
)  # Timeout associated with remote calls (in ms)
class Py4jHelloImpl(HelloImpl):
    """
    All method implementations handled by HelloImpl super-class.

    See samples.rsa.helloimpl module.
    """

    pass
