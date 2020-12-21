package creational.singleton.basic;

import java.io.Serializable;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class StaticFieldSingleton implements Serializable {

	public static final StaticFieldSingleton INSTANCE = new StaticFieldSingleton();

	private String name;

	private StaticFieldSingleton() {
	}

	public static StaticFieldSingleton getInstance() {
		return INSTANCE;
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
