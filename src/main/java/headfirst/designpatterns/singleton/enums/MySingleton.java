package headfirst.designpatterns.singleton.enums;

import java.io.ObjectStreamException;
import java.io.Serializable;

public final class MySingleton implements Serializable {
    private MySingleton() {
    }

    private static final MySingleton INSTANCE = new MySingleton();

    public static MySingleton getInstance() {
        return INSTANCE;
    }

    private Object readResolve() throws ObjectStreamException {
        // instead of the object we're on,
        // return the class variable INSTANCE
        return INSTANCE;
    }
}
