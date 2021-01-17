package creational.singleton.lazy;

import java.io.Serializable;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class SynchronizedMethodSingleton implements Serializable {

	private static SynchronizedMethodSingleton INSTANCE;

	private String name;

	private SynchronizedMethodSingleton() {

	}

	public static synchronized SynchronizedMethodSingleton getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SynchronizedMethodSingleton();
		}
		return INSTANCE;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printHello() {
		System.out.println("Hello");
	}

	protected Object readResolve() {
		return getInstance();
	}

}
