package headfirst.designpatterns.proxy.javaproxymultiintfs;

public class PersonBeanBImpl implements PersonBeanB {

    @Override
    public String getName2() {
        System.out.println("PersonBeanBImpl");
        return "PersonBeanBImpl";
    }
}
