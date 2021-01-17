package behavioral.state;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class TerminatedState implements ThreadState {
	@Override
	public void run() {
		throw new RuntimeException("Thread is terminated. Unable to run");
	}
}
