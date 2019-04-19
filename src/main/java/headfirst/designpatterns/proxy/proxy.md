- 代理模式

- 控制和管理访问

- 所谓的代理，就是代理某个真实的对象

- 远程代理(RMI) (远程接口实现继承Remote接口) 代理模式的一种实现
    - 远程对象的本地代表
    - 远程对象是一种活在不同JVM堆中的对象
    - 本地代表是一种可以由本地方法调用的对象，其行为会转发到远程对象中
    
    
- 代理模式为另一个对象创建一个替身或占位符以及控制对这个对象的访问
    - 远程代理控制访问远程对象
    - 虚拟代理控制访问创建开销大的资源
    - 保护代理基于权限控制对资源的访问
    
- 保护代理(利用Java的动态代理创建)

- [动态代理](./javaproxy)：代理类是在运行时创建的 
    - InvocationHandler 实现代理的行为
    - 运行时才将代理类创建出来
    - 代理类继承了Proxy类并实现了代理的接口