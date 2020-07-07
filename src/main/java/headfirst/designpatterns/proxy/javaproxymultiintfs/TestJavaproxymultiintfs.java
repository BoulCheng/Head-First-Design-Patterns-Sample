package headfirst.designpatterns.proxy.javaproxymultiintfs;

import java.lang.reflect.Proxy;

public class TestJavaproxymultiintfs {


    /**
     * Class<?>[] interfaces, 数组如果多个接口，那么生成的代理类实现多个接口
     * 通过 InvocationHandler 实现类的实例来实例化代理类 进而代理真实对象， 代理类的实例只能赋值给 Class<?>[] interfaces 中的接口
     * 在 InvocationHandler 可以通过Method的声明接口 判断方法是属于哪个接口的，进而通过该接口的实现类的实例调用方法，实现代理真实对象
     *
     * 如果多个接口方法名和参数相同 那么该方法只属于 Class<?>[] interfaces 中顺序靠前的接口
     * 代理类方法
     * @param args
     */
//
//package com.sun.proxy;
//
//import headfirst.designpatterns.proxy.javaproxymultiintfs.PersonBeanA;
//import headfirst.designpatterns.proxy.javaproxymultiintfs.PersonBeanB;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//import java.lang.reflect.UndeclaredThrowableException;
//
//    public final class $Proxy0 extends Proxy implements PersonBeanB, PersonBeanA {
//        private static Method m1;
//        private static Method m4;
//        private static Method m2;
//        private static Method m3;
//        private static Method m0;
//
//        public $Proxy0(InvocationHandler var1) throws  {
//            super(var1);
//        }
//
//        public final boolean equals(Object var1) throws  {
//            try {
//                return (Boolean)super.h.invoke(this, m1, new Object[]{var1});
//            } catch (RuntimeException | Error var3) {
//                throw var3;
//            } catch (Throwable var4) {
//                throw new UndeclaredThrowableException(var4);
//            }
//        }
//
//        public final String getName() throws  {
//            try {
//                return (String)super.h.invoke(this, m4, (Object[])null);
//            } catch (RuntimeException | Error var2) {
//                throw var2;
//            } catch (Throwable var3) {
//                throw new UndeclaredThrowableException(var3);
//            }
//        }
//
//        public final String toString() throws  {
//            try {
//                return (String)super.h.invoke(this, m2, (Object[])null);
//            } catch (RuntimeException | Error var2) {
//                throw var2;
//            } catch (Throwable var3) {
//                throw new UndeclaredThrowableException(var3);
//            }
//        }
//
//        public final String getName2() throws  {
//            try {
//                return (String)super.h.invoke(this, m3, (Object[])null);
//            } catch (RuntimeException | Error var2) {
//                throw var2;
//            } catch (Throwable var3) {
//                throw new UndeclaredThrowableException(var3);
//            }
//        }
//
//        public final int hashCode() throws  {
//            try {
//                return (Integer)super.h.invoke(this, m0, (Object[])null);
//            } catch (RuntimeException | Error var2) {
//                throw var2;
//            } catch (Throwable var3) {
//                throw new UndeclaredThrowableException(var3);
//            }
//        }
//
//        static {
//            try {
//                m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
//                m4 = Class.forName("headfirst.designpatterns.proxy.javaproxymultiintfs.PersonBeanA").getMethod("getName");
//                m2 = Class.forName("java.lang.Object").getMethod("toString");
//                m3 = Class.forName("headfirst.designpatterns.proxy.javaproxymultiintfs.PersonBeanB").getMethod("getName2");
//                m0 = Class.forName("java.lang.Object").getMethod("hashCode");
//            } catch (NoSuchMethodException var2) {
//                throw new NoSuchMethodError(var2.getMessage());
//            } catch (ClassNotFoundException var3) {
//                throw new NoClassDefFoundError(var3.getMessage());
//            }
//        }
//    }

    public static void main(String[] args) {


        //保存生成的字节码 com.sun.proxy.$Proxy0
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Object object = Proxy.newProxyInstance(TestJavaproxymultiintfs.class.getClassLoader(), new Class[]{ PersonBeanB.class, PersonBeanA.class}, new PersonInvocationHandler(new PersonBeanAImpl(), new PersonBeanBImpl()));
        Object object2 = Proxy.newProxyInstance(TestJavaproxymultiintfs.class.getClassLoader(), new Class[]{ PersonBeanB.class, PersonBeanA.class}, new PersonInvocationHandler(new PersonBeanAImpl(), new PersonBeanBImpl()));

        PersonBeanA personBeanA = (PersonBeanA) object;
        personBeanA.getName();
        PersonBeanB personBeanB = (PersonBeanB) object;
        personBeanB.getName2();

//        Object object = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{PersonBeanA.class, PersonBeanB.class}, new PersonInvocationHandler());
//        PersonBeanA personBeanA = (PersonBeanA)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{PersonBeanA.class, PersonBeanB.class}, new PersonInvocationHandler(new PersonBeanAImpl(), new PersonBeanBImpl()));
//        PersonBeanB personBeanB = (PersonBeanB)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{PersonBeanA.class, PersonBeanB.class}, new PersonInvocationHandler(new PersonBeanAImpl(), new PersonBeanBImpl()));
//        System.out.println(object);

    }
}
