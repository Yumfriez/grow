package behavioral.observer;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class TravisEvent implements Event<String> {

	private final String status;

	public TravisEvent(String status) {
		this.status = status;
	}

	@Override
	public String getSource() {
		return status;
	}
}
