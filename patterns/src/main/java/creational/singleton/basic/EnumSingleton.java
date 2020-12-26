package creational.singleton.basic;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public enum EnumSingleton {

	INSTANCE;

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static EnumSingleton getInstance() {
		return INSTANCE;
	}
}
