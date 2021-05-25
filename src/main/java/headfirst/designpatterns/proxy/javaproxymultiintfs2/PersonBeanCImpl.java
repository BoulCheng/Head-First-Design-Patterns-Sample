package headfirst.designpatterns.proxy.javaproxymultiintfs2;

public class PersonBeanCImpl implements PersonBeanC {

    @Override
    public String getName() {
        System.out.println("PersonBeanCImpl");
        return "PersonBeanCImpl";
    }
}
