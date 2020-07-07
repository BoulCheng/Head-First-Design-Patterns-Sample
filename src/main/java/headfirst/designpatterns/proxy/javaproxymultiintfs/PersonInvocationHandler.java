package headfirst.designpatterns.proxy.javaproxymultiintfs;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PersonInvocationHandler implements InvocationHandler {

    private PersonBeanAImpl personBeanA;
    private PersonBeanBImpl personBeanB;


    public PersonInvocationHandler(PersonBeanAImpl personBeanA, PersonBeanBImpl personBeanB) {
        this.personBeanA = personBeanA;
        this.personBeanB = personBeanB;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> c = method.getDeclaringClass();
        System.out.println(c.getName() + "-" + method.getName());
        if (c == PersonBeanA.class) {
            return method.invoke(personBeanA, args);
        } else if (c == PersonBeanB.class) {
           return method.invoke(personBeanB, args);
        } else {
            return null;
        }
    }
}
