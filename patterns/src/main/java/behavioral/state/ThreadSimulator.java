package behavioral.state;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class ThreadSimulator {

	private ThreadState threadState;

	public ThreadSimulator(ThreadState threadState) {
		this.threadState = threadState;
	}

	public void run() throws InterruptedException {
		while (true) {
			threadState.run();
			Thread.sleep(500L);
		}
	}

	public ThreadState getThreadState() {
		return threadState;
	}

	public void setThreadState(ThreadState threadState) {
		this.threadState = threadState;
	}
}
