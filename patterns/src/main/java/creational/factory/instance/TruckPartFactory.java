package creational.factory.instance;

import creational.factory.entity.*;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class TruckPartFactory implements PartFactory {

	private static final TruckPartFactory INSTANCE = new TruckPartFactory();

	private TruckPartFactory() {
	}

	public static TruckPartFactory getInstance() {
		return INSTANCE;
	}

	protected Object readResolve() {
		return getInstance();
	}

	@Override
	public Carcase createCarcase() {
		return new TruckCarcase();
	}

	@Override
	public Engine createEngine() {
		return new TruckEngine();
	}

	@Override
	public Wheel createWheel() {
		return new TruckWheel();
	}
}
