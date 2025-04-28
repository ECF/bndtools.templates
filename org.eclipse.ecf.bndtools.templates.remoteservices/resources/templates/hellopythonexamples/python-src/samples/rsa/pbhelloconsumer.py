
# original version of this program available as part of iPOPO project
# at https://github.com/tcalmant/ipopo

from typing import Any
from pelix.framework import BundleContext
from pelix.ipopo.decorators import ComponentFactory, Instantiate, Requires, Validate
from samples.rsa.hellomsg_pb2 import HelloMsgContent


def create_hellomsgcontent(message: str) -> HelloMsgContent:
    resmsg = HelloMsgContent()
    resmsg.h = "Message from Python"
    resmsg.f = "Python consumer"
    resmsg.to = "tojava"
    resmsg.hellomsg = message
    for x in range(0, 5):
        resmsg.x.append(float(x))
    return resmsg


@ComponentFactory("remote-pbhello-consumer-factory")
# The '(service.imported=*)' filter only allows remote hello service
# proxies to be injected
@Requires(
    "_helloservice",
    "org.eclipse.ecf.examples.protobuf.hello.IHello",
    False,
    False,
    "(service.imported=*)",
    False,
)
@Instantiate("remote_pbhello-consumer")
class RemotePbHelloConsumer:
    _helloservice: Any

    @Validate
    def _validate(self, bcontext: BundleContext) -> None:
        # call it!
        resp = self._helloservice.sayHello(create_hellomsgcontent("pbPython consumer calling pb.sayHello"))
        print("pb sayHello received response: {0}".format(resp))
        # call sayHelloAsync which returns future and we lambda to print the
        # result when done
        self._helloservice.sayHelloAsync(
            create_hellomsgcontent("pbPython consumer calling pb.sayHelloAsynch")
        ).add_done_callback(lambda f: print("pbasync respon: {0}".format(f.result())))
        print("done with pb.sayHelloAsync")
        # call sayHelloAsync which returns Future and we add lambda to print
        # the result when done
        self._helloservice.sayHelloPromise(
            create_hellomsgcontent("pbPython consumer calling pb.sayHelloPromise")
        ).add_done_callback(lambda f: print("pbpromise response: {0}".format(f.result())))
        print("done with sayHelloPromise")
