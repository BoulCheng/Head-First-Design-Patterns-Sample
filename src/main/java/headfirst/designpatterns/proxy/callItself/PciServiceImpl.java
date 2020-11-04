package headfirst.designpatterns.proxy.callItself;

public class PciServiceImpl implements PciService {

    @Override
    public void call() {
        System.out.println("call");
        // 自调用时并不会代理方法 调用对象this是真实对象
        callInner();
    }

    @Override
    public void callInner() {
        System.out.println("callInner");
    }
}
