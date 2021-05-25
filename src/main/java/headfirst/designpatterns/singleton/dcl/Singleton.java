package headfirst.designpatterns.singleton.dcl;

//
// Danger!  This implementation of Singleton not
// guaranteed to work prior to Java 5
//

import java.io.ObjectStreamException;

public class Singleton {
	private volatile static Singleton uniqueInstance;
 
	private Singleton() {}
 
	public static Singleton getInstance() {
		if (uniqueInstance == null) {
			synchronized (Singleton.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new Singleton();
				}
			}
		}
		return uniqueInstance;
	}

	/**
	 * 如果实现序列化接口 单例可以选择不实现序列化接口
	 *
	 * @return
	 * @throws ObjectStreamException
	 */
	private Object readResolve() throws ObjectStreamException {
		// instead of the object we're on,
		// return the class variable INSTANCE
		return Singleton.getInstance();
	}


	public static void main(String[] args) throws Exception {

//
//        //开始序列化对象
//        FileOutputStream fos = new FileOutputStream(new File("enumSingletonTest.out"));
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(SingletonObject7.getInstance());
//        //开始反序列化对象
//        FileInputStream fis = new FileInputStream(new File("enumSingletonTest.out"));
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        SingletonObject7 singletonObject7 = (SingletonObject7) ois.readObject();
//        System.out.println(singletonObject7 == SingletonObject7.getInstance());

	}


}
