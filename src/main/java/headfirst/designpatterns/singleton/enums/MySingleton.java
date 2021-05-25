package headfirst.designpatterns.singleton.enums;

import java.io.ObjectStreamException;
import java.io.Serializable;

public final class MySingleton implements Serializable {
    private MySingleton() {
    }

    private static final MySingleton INSTANCE = new MySingleton();

    public static MySingleton getInstance() {
        return INSTANCE;
    }

    private Object readResolve() throws ObjectStreamException {
        // instead of the object we're on,
        // return the class variable INSTANCE
        return INSTANCE;
    }


    /**
     * 不要继承Serializable接口
     */
    interface My2Singleton {
        String ss = null;

        default String gg() {
            return "";
        }
        void doSomething();
    }

    /**
     * 枚举类型是线程安全的，并且只会装载一次
     * 反编译可以看到继承了Enum类
     *
     * JVM 保证一个constant构造函数绝对只调用一次
     * The constructor for an enum type must be package-private or private access.
     * It automatically creates the constants that are defined at the beginning of the enum body.
     * You cannot invoke an enum constructor yourself.
     * 私有构造函数
     * JVM层面禁止了通过反射构造枚举实例的行为 即使是获取了正确的构造函数
     * clone 方法也被重写抛出异常
     * 有几个 constant 就会调用几次实例构造函数
     */
    enum Singleton implements My2Singleton {
        /**
         * 枚举的成员就是一个枚举(实例)对象，只不过它们是静态常量(public static final 修饰)而已。
         * 此处是调用了默认的无参构造器Color
         */
        INSTANCE {
            @Override
            public void doSomething() {
                System.out.println("complete singleton");
            }
        };

        public static My2Singleton getInstance() {
            return Singleton.INSTANCE;
        }

    }




}
