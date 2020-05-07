package headfirst.designpatterns.singleton.enums;


/**
 * 唯一一种不会被破坏的单例实现模式
 */
public class SingletonObject7 {
    private SingletonObject7(){
    }

    /**
     * 枚举类型是线程安全的，并且只会装载一次
     *
     * 反编译可以看到继承了Enum类
     */
    private enum Singleton{
        INSTANCE;

        private final SingletonObject7 instance;

        // // JVM 保证这个方法绝对只调用一次
        // The constructor for an enum type must be package-private or private access.
        // It automatically creates the constants that are defined at the beginning of the enum body.
        // You cannot invoke an enum constructor yourself.
        // 私有构造函数
        // JVM层面禁止了通过反射构造枚举实例的行为 即使是获取了正确的构造函数
        // clone 方法也被重现抛出异常
        Singleton(){
            instance = new SingletonObject7();
        }

        private SingletonObject7 getInstance(){
            return instance;
        }
    }

    public static SingletonObject7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }
}