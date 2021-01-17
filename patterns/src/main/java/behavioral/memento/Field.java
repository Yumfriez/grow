package behavioral.memento;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Field<T> {

	private String name;
	private T type;

	public Field(String name, T type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getType() {
		return type;
	}

	public void setType(T type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Field{" + "name='" + name + '\'' + ", type=" + type + '}';
	}
}
