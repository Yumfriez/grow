package creational.prototype;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static void main(String[] args) {

		final CloneableSecondLevel cloneable = new CloneableSecondLevel();

		cloneable.setName("name");
		cloneable.setDescription("description");

		List<String> attributes = new ArrayList<>();
		attributes.add("hello");
		cloneable.setAttributes(attributes);

		final CloneableSecondLevel deepClone = cloneable.clone(true);
		final CloneableSecondLevel simpleClone = cloneable.clone(false);

		Assertions.assertEquals(cloneable.getName(), deepClone.getName());
		Assertions.assertEquals(cloneable.getDescription(), deepClone.getDescription());
		Assertions.assertEquals(cloneable.getAttributes(), deepClone.getAttributes());

		Assertions.assertEquals(cloneable.getAttributes(), simpleClone.getAttributes());

		cloneable.getAttributes().remove(0);
		Assertions.assertNotEquals(cloneable.getAttributes(), deepClone.getAttributes());

		Assertions.assertEquals(cloneable.getAttributes(), simpleClone.getAttributes());
	}
}
