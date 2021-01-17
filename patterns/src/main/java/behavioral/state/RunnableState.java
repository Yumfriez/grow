package behavioral.state;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class RunnableState implements ThreadState {
	@Override
	public void run() {
		System.out.println("Ready to run state");
	}
}
