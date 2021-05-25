package headfirst.designpatterns.proxy.javaproxymultiintfs2;

import headfirst.designpatterns.proxy.javaproxymultiintfs.PersonBeanB;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonInvocationHandler implements InvocationHandler {

    private PersonBeanCImpl personBeanC;

    public PersonInvocationHandler(PersonBeanCImpl personBeanC) {
        this.personBeanC = personBeanC;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> c = method.getDeclaringClass();
        System.out.println(c.getName() + "-" + method.getName());
        if (c == PersonBeanC.class) {
            return method.invoke(personBeanC, args);
        } else if (method.getName().equals("getSex")) {
            System.out.println("getSex invoked!");
            return "getSex";
        } else {
            return null;
        }
    }
}
