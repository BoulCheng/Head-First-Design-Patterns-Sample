package headfirst.designpatterns.singleton.staticInnerClass;


/**
 * 静态内部类单例模式
 * 实例由内部类创建，由于 JVM 在加载外部类的过程中, 是不会加载静态内部类的, 只有内部类的属性/方法被调用时才会被加载, 并初始化其静态属性
 *
 * 在没有加任何锁的情况下，保证了多线程下的安全，并且没有任何性能影响和空间的浪费。
 */
public class SingletonObject6 {

    private SingletonObject6() {
    }

    private static class SingletonHolder {
        private final static SingletonObject6 singleton = new SingletonObject6();
    }

    public static SingletonObject6 getSingleton() {
        return SingletonHolder.singleton;
    }
}
