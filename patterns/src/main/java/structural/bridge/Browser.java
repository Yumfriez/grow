package structural.bridge;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Browser extends AbstractApp {

	public Browser(String name) {
		super(name);
	}

	@Override
	public void start() {
		System.out.println("Start browser: " + getName());
		setRunning(true);
	}

	@Override
	public void stop() {
		System.out.println("Stop browser: " + getName());
		setRunning(false);
	}
}
