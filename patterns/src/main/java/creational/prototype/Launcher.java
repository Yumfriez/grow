package creational.prototype;

import org.junit.jupiter.api.Assertions;

import java.util.Collections;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static void main(String[] args) {

		final CloneableSecondLevel cloneable = new CloneableSecondLevel();

		cloneable.setName("name");
		cloneable.setDescription("description");
		cloneable.setAttributes(Collections.singletonList("hello"));

		final CloneableSecondLevel clone = cloneable.clone(true);

		Assertions.assertEquals(cloneable.getName(), clone.getName());
		Assertions.assertEquals(cloneable.getDescription(), clone.getDescription());
		Assertions.assertEquals(cloneable.getAttributes(), clone.getAttributes());
	}
}
