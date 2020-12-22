package creational.factory.entity;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class PassengerCarCarcase implements Carcase {
	@Override
	public int getLiftLimit() {
		return 900;
	}
}
