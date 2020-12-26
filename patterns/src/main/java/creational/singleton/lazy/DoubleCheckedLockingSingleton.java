package creational.singleton.lazy;

import java.io.Serializable;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class DoubleCheckedLockingSingleton implements Serializable {

	private static volatile DoubleCheckedLockingSingleton instance;

	private String name;

	private DoubleCheckedLockingSingleton() {
	}

	public static DoubleCheckedLockingSingleton getInstance() {
		DoubleCheckedLockingSingleton localInstance = instance;
		if (localInstance == null) {
			synchronized (DoubleCheckedLockingSingleton.class) {
				localInstance = instance;
				if (localInstance == null) {
					instance = localInstance = new DoubleCheckedLockingSingleton();
				}
			}
		}
		return localInstance;
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
