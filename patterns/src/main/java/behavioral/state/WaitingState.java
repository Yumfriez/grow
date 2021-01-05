package behavioral.state;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class WaitingState implements ThreadState {

	private final ThreadSimulator threadSimulator;

	public WaitingState(ThreadSimulator threadSimulator) {
		this.threadSimulator = threadSimulator;
	}

	@Override
	public void run() {
		try {
			System.out.println("Waiting for locked resource...");
			Thread.sleep(1000L);
			System.out.println("Changing state to running...");
			threadSimulator.setThreadState(new RunningState());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
