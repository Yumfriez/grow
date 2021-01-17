package creational.prototype;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class CloneableFirstLevel implements Cloneable {

	private String name;

	public CloneableFirstLevel() {
	}

	public CloneableFirstLevel(CloneableFirstLevel firstLevel) {
		this.name = firstLevel.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public CloneableFirstLevel clone(boolean isDeep) {
		return new CloneableFirstLevel(this);
	}
}
