package creational.singleton.lazy;

import java.io.Serializable;

/**
 *
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class OnDemandHolderSingleton implements Serializable {

	private String name;

	private OnDemandHolderSingleton() {
	}

	public static class SingletonHolder {
		private static final OnDemandHolderSingleton HOLDER_INSTANCE = new OnDemandHolderSingleton();
	}

	public static OnDemandHolderSingleton getInstance() {
		return SingletonHolder.HOLDER_INSTANCE;
	}

	public void printHello() {
		System.out.println("hello");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected Object readResolve() {
		return getInstance();
	}
}
