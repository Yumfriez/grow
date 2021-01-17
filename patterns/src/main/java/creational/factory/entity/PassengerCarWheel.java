package creational.factory.entity;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class PassengerCarWheel implements Wheel {

	@Override
	public int getWeight() {
		return 50;
	}

	@Override
	public void spin() {
		System.out.println("Passenger car wheel is spinning...");
	}
}
