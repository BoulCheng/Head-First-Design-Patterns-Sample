package headfirst.designpatterns.proxy.callItself;

import java.lang.reflect.Proxy;

public class PciTest {


    public static void main(String[] args) {
        PciService pciService = new PciServiceImpl();
        Object proxy = Proxy.newProxyInstance(pciService.getClass().getClassLoader(), pciService.getClass().getInterfaces(), new PciInvocationHandler(pciService));

        PciService pciService1 = (PciService) proxy;
        pciService1.call();
    }
}
