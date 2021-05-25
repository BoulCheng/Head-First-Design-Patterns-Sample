package headfirst.designpatterns.proxy.javaproxymultiintfs2;

import headfirst.designpatterns.proxy.javaproxymultiintfs.PersonBeanB;

import java.lang.reflect.Proxy;

/**
 * 类似 AOP 为引入新增方法
 */
public class TestJavaproxymultiintfs2 {


    public static void main(String[] args) {


        //保存生成的字节码 com.sun.proxy.$Proxy0
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Object object = Proxy.newProxyInstance(TestJavaproxymultiintfs2.class.getClassLoader(), new Class[]{PersonBeanD.class, PersonBeanC.class}, new PersonInvocationHandler(new PersonBeanCImpl()));

        PersonBeanC personBeanC = (PersonBeanC) object;
        personBeanC.getName();
        PersonBeanD personBeanD = (PersonBeanD) object;
        personBeanD.getSex();

//        Object object = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{PersonBeanA.class, PersonBeanB.class}, new PersonInvocationHandler());
//        PersonBeanA personBeanA = (PersonBeanA)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{PersonBeanA.class, PersonBeanB.class}, new PersonInvocationHandler(new PersonBeanAImpl(), new PersonBeanBImpl()));
//        PersonBeanB personBeanB = (PersonBeanB)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{PersonBeanA.class, PersonBeanB.class}, new PersonInvocationHandler(new PersonBeanAImpl(), new PersonBeanBImpl()));
//        System.out.println(object);

    }
}
