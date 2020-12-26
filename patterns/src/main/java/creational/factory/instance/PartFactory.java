package creational.factory.instance;

import creational.factory.entity.Carcase;
import creational.factory.entity.Engine;
import creational.factory.entity.Wheel;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public interface PartFactory {

	Carcase createCarcase();
	Engine createEngine();
	Wheel createWheel();
}
