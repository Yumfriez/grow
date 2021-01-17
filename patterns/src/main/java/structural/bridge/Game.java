package structural.bridge;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Game extends AbstractApp {

	public Game(String name) {
		super(name);
	}

	@Override
	public void start() {
		System.out.println("Start game: " + getName());
		setRunning(true);
	}

	@Override
	public void stop() {
		System.out.println("Stop game: " + getName());
		setRunning(false);
	}
}
