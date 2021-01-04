package behavioral.state;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class RunningState implements ThreadState {
	@Override
	public void run() {
		System.out.println("Doing something in running state...");
	}
}
