package creational.factory.entity;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class TruckEngine implements Engine {
	@Override
	public int getWeight() {
		return 1000;
	}

	@Override
	public void run() {
		System.out.println("Truck engine is running...");
	}
}
