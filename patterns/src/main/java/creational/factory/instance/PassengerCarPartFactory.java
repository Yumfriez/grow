package creational.factory.instance;

import creational.factory.entity.*;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class PassengerCarPartFactory implements PartFactory {

	private static final PassengerCarPartFactory INSTANCE = new PassengerCarPartFactory();

	private PassengerCarPartFactory() {
	}

	public static PassengerCarPartFactory getInstance() {
		return INSTANCE;
	}

	protected Object readResolve() {
		return getInstance();
	}

	@Override
	public Carcase createCarcase() {
		return new PassengerCarCarcase();
	}

	@Override
	public Engine createEngine() {
		return new PassengerCarEngine();
	}

	@Override
	public Wheel createWheel() {
		return new PassengerCarWheel();
	}
}
