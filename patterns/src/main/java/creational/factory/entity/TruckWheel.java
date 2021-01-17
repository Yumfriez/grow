package creational.factory.entity;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class TruckWheel implements Wheel {
	@Override
	public int getWeight() {
		return 100;
	}

	@Override
	public void spin() {
		System.out.println("Truck car wheel is spinning...");
	}
}
