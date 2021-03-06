# 工厂模式

- new公开实例化经常会造成耦合. 除了new操作符之外还有更多制造对象的方法

- 当代码使用大量具体类时，一旦加入新的具体类就必须修改代码，并非对修改关闭.

- 工厂只处理创建对象的细节. 创建对象的工厂类可以在整个应用程序的各个地方被使用.

- 所有工厂模式都用来封装对象的创建

- 将创建对象的代码集中在一个对象或方法中可以进行复用. 实例化对象时只依赖接口遵循了针对接口编程.

- 不可改变的类直接new

- 工厂模式用于减少应用程序和具体类之间的依赖促进解耦

- 面向接口编程(所有具体对象要有一个共同的超类型)解耦对修改关闭 封装对象创建进行复用

- 简单工厂
    - 简单静态工厂: 把工厂类中创建具体对象的方法定义为静态方法. 优点是工厂类不再需要实例化, 但缺点是不能通过继承改变这个方法的行为.
    
    - 简单工厂: 有一个工厂类, 工厂类中创建具体对象的统一方法通常是静态的, 工厂类中也是整个应用程序唯一用到具体类的地方. 所有具体对象要有一个共同的超类型. 

- 工厂方法模式
    - 正式定义: 定义一个创建对象的接口，由子类决定实例化的具体类，把实例化推迟到了子类
    - 工厂方法模式是将操作产品的一些方法和抽象的工厂方法定义在一个抽象创建者类里，子类实现抽象的工厂方法生产具体产品
    - 工厂方法模式实际上提供了一种框架. 提供了一系列可以操作(变更)对象(实际是由抽象工厂方法返回的抽象产品)的公共方法. 纯粹把创建对象放在了子类的对抽象工厂方法的实现中.
    
    - 通过让子类决定该创建的对象是什么来达到将对象创建的过程封装的目的.
    - 抽象创建者定义了一个抽象的工厂方法, 且只依赖抽象产品
    - 具体创建者实现抽象的工厂方法生产具体产品
    - 当仅有一个具体创建者时工厂方法模式的优势:
        - 其实抽象创建者实际上包含了一些产品的使用方法，当然这些方法仅依赖于抽象产品, 因此可以将产品的使用和产品的创建解耦
        - 如果要增加产品或改变产品并不会影响到抽象创建者及产品的使用
        
    - 与简单工厂的区别:
        - 简单工厂将创建类封装在一个独立的工厂类里，然后操作产品的类组合该工厂类. 而工厂方法模式是将操作产品的一些方法和抽象的工厂方法定义在一个抽象创建者类里
        - 工厂方法模式实际上提供了一种框架. 提供了一系列可以操作(变更)对象(实际是由抽象工厂方法返回的抽象产品)的公共方法. 纯粹把创建对象放在了子类的对抽象工厂方法的实现中.
    - 用于创建一个产品
- 在具体创建者中通过参数创建具体的产品，这种方式称为参数化工厂方法. 然而工厂经常只生产一种对象通常不需要参数.
    
- 设计原则: 
    - 依赖倒置原则: 要依赖抽象，不要依赖具体类
        - 相比针对接口编程，这个原则更强调抽象，
        - 不能让高层组件依赖低层组件，且高层或低层组件都应该依赖于抽象. 高层组件是有其他低层组件定义其行为的类.
        - 具体产品类依赖抽象产品类-依赖倒置现象
        
        - 遵循该原则指导方针 
        
        
- 抽象工厂模式
    - 正式定义:提供一个接口，用户创建创建相关或依赖对象的家族，而不需要明确指定具体类
    - 用户创建产品家族或者创建一组需要集合起来的对象
    - 抽象工厂模式中利用工厂方法模式实现. 抽象工厂的实现-具体工厂用于创建一组相关的对象(如场地不同的各类蔬菜，A产地一个具体工厂类，B产地一个具体工厂类，两个产地都生产各类蔬菜)，而创建该组对象的每一个对象的方式就是使用工厂方法模式. 具体类由抽象工厂的工厂方法产生.
    - 抽象工厂的每个方法其实是工厂方法
    