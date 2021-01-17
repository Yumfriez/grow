package structural.bridge;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public abstract class AbstractApp implements App {

	private final String name;
	private boolean running;

	protected AbstractApp(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	@Override
	public String getState() {
		return running ? "RUNNING" : "STOPPED";
	}
}
