package headfirst.designpatterns.proxy.javaproxymultiintfs;

public class PersonBeanAImpl implements PersonBeanA {

    @Override
    public String getName() {
        System.out.println("PersonBeanAImpl");
        return "PersonBeanAImpl";
    }
}
