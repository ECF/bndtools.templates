#!/usr/bin/python3
from typing import Any

# original version of this program available as part of iPOPO project
# at https://github.com/tcalmant/ipopo
from pelix.framework import BundleContext
from pelix.ipopo.decorators import ComponentFactory, Instantiate, Requires, Validate

@ComponentFactory("remote-hello-consumer-factory")
# The '(service.imported=*)' filter only allows remote services to be injected
@Requires(
    "_helloservice",
    "org.eclipse.ecf.examples.hello.IHello",
    False,
    False,
    "(service.imported=*)",
    False,
)
@Instantiate("remote-hello-consumer")
class RemoteHelloConsumer:
    _helloservice: Any

    def __init__(self) -> None:
        self._name = "Python"
        self._msg = "Hello Java"

    @Validate
    def _validate(self, bundle_context: BundleContext) -> None:
        # call it!
        resp = self._helloservice.sayHello(self._name + "Sync", self._msg)
        print(self._name, "IHello service consumer received sync response:", resp)

        # call sayHelloAsync which returns Future and we add lambda to print
        # the result when done
        self._helloservice.sayHelloAsync(self._name + "Async", self._msg).add_done_callback(
            lambda f: print("async response:", f.result())
        )
        print("done with sayHelloAsync method")

        # call sayHelloAsync which returns Future and we add lambda to print
        # the result when done
        self._helloservice.sayHelloPromise(self._name + "Promise", self._msg).add_done_callback(
            lambda f: print("promise response:", f.result())
        )
        print("done with sayHelloPromise method")
