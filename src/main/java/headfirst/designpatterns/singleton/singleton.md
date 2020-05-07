# singleton

- 类仅有一个实例

- 实例构造器是私有化

- 单件模式: 确保一个类只有一个实例，并提供一个全局的访问点(公共的静态方法), (私有的类静态变量持有该单件)
    - 私有实例构造器
    - 私有静态变量
    - 公有的静态方法

- "急切"(总是需要该单件且创建和运行负担轻) 可以使用类静态变量实现. 但该类初始化的时候该实例就一定会被创建. 无法做到延迟实例化(针对资源敏感的单件)
    ```
    //在静态初始化器中创建单件. 虚拟机会保证一个类的＜clinit＞()方法在多线程环境中被正确地加锁、同步
    public class Singleton {
        private static Singleton uniqueInstance = new Singleton();
     
        private Singleton() {}
     
        public static Singleton getInstance() {
            return uniqueInstance;
        }
        
    }
    ```
    
- 双重检查加锁
    ```
    
    public class Singleton {
        // 必须volatile保证可见性
        private volatile static Singleton uniqueInstance;
     
        private Singleton() {}
     
        public static Singleton getInstance() {
            if (uniqueInstance == null) {
                synchronized (Singleton.class) {
                    if (uniqueInstance == null) {
                        uniqueInstance = new Singleton();
                    }
                }
            }
            return uniqueInstance;
        }
    }
    ```
    
- 类单件: 类的所有方法和变量都定义为静态的. 如果类自给自足且不依赖复杂的初始化可以这么做，但要注意类初始化的顺序问题. 使用对象的单件比较保险

- 但程序中有多个类加载器又同时使用了单件模式，那要避免一个类加载器产生一个实例的情况导致单件失效. 可以自行指定同一个类加载器

- 继承单件会导致所有的派生类共享父类的保存单件的类静态变量

- 全局变量虽然可以提供全局的访问，但并不保证只有一个实例.

- 除枚举方式外, 其他方法都会通过反射的方式破坏单例,反射是通过调用构造方法生成新的对象，所以如果我们想要阻止单例破坏，可以在构造方法中进行判断，若已有实例, 则阻止生成新的实例

- 如果单例类实现了序列化接口Serializable, 就可以通过反序列化破坏单例，所以我们可以不实现序列化接口,如果非得实现序列化接口，可以重写反序列化方法readResolve(), 反序列化时直接返回相关单例对象