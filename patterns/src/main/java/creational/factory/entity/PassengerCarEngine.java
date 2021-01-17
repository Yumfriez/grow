package creational.factory.entity;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class PassengerCarEngine implements Engine {
	@Override
	public int getWeight() {
		return 500;
	}

	@Override
	public void run() {
		System.out.println("Passenger car engine is running...");
	}
}
