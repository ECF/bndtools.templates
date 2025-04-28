# original version of this program available as part of iPOPO project
# at https://github.com/tcalmant/ipopo

from concurrent.futures import Future
from concurrent.futures.thread import ThreadPoolExecutor

from pelix.ipopo.decorators import ComponentFactory, Provides, Instantiate
from samples.rsa.hellomsg_pb2 import HelloMsgContent


def create_hellomsgcontent(message:str) -> HelloMsgContent:
    resmsg = HelloMsgContent()
    resmsg.h = "Response from Python"
    resmsg.f = "Python Impls"
    resmsg.to = "tojava"
    resmsg.hellomsg = message
    for x in range(0, 5):
        resmsg.x.append(float(x))
    return resmsg

@ComponentFactory("pbhelloimpl-py4j-factory")
# Provides IHello interface as specified by Java interface.
@Provides("org.eclipse.ecf.examples.protobuf.hello.IHello")
# See <a
# href="https://github.com/ECF/Py4j-RemoteServicesProvider/blob/master/examples/org.eclipse.ecf.examples.protobuf.hello/src/org/eclipse/ecf/examples/protobuf/hello/IHello.java">IHello
# service interface</a>
@Instantiate(
    "pbhelloimpl-py4j",
    {
        "service.exported.interfaces": "*",
        "service.exported.configs": "ecf.py4j.python.protobuf.host",
        "service.intents": ["osgi.async"],
        "osgi.basic.timeout": 120000,
    },
)
class PbHelloImpl:
    """
    Implementation of Java org.eclipse.ecf.examples.protobuf.hello.IHello
    service interface.
    """

    def sayHello(self, hellomsg: HelloMsgContent) -> HelloMsgContent:
        """
        Synchronous implementation of IHello.sayHello synchronous method.
        The remote calling thread will be blocked until this is executed and
        responds
        """
        print(
            "pbPython.sayHello called by: {0} "
            "with message: '{1}'".format(hellomsg.f, hellomsg)
        )
        return create_hellomsgcontent(
            "pythonpbhello responds: Howdy {0} "
            "that's a nice runtime you got there".format(hellomsg.f)
        )

    def sayHelloAsync(self, hellomsg: HelloMsgContent) -> HelloMsgContent:
        print(
            "Python.sayHelloAsync called by: {0} "
            "with message: '{1}'".format(hellomsg.f, hellomsg)
        )
        return create_hellomsgcontent(
            "pythonpbhello responds: Howdy {0} "
            "that's a nice runtime you got there".format(hellomsg.f)
        )

    def _sayHelloFuture(self, hellomsg: HelloMsgContent) -> HelloMsgContent:
        print(
            "Python.sayHelloFuture called by: {0} "
            "with message: '{1}'".format(hellomsg.f, hellomsg)
        )
        return create_hellomsgcontent(
            "pythonpbhello responds: Howdy {0} "
            "that's a nice runtime you got there".format(hellomsg.f)
        )

    def sayHelloPromise(self, hellomsg: HelloMsgContent) -> Future[HelloMsgContent]:
        print(
            "Python.sayHelloPromise called by: {0} "
            "with message: '{1}'".format(hellomsg.f, hellomsg)
        )
        with ThreadPoolExecutor(2) as executor:
            return executor.submit(self._sayHelloFuture, hellomsg)
