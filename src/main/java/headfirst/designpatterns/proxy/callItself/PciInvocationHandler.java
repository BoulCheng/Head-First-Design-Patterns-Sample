package headfirst.designpatterns.proxy.callItself;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PciInvocationHandler implements InvocationHandler {

    private PciService pciService;

    public PciInvocationHandler(PciService pciService) {
        this.pciService = pciService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----" + method.getName());
        return method.invoke(pciService, args);
    }
}
