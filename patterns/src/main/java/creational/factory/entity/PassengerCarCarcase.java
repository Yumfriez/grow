package creational.factory.entity;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class PassengerCarCarcase implements Carcase {
	@Override
	public int getLiftLimit() {
		return 900;
	}
}
