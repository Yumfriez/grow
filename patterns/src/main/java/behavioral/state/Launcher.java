package behavioral.state;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static void main(String[] args) throws InterruptedException {
		ThreadSimulator threadSimulator = new ThreadSimulator(new RunnableState());

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		executorService.execute(() -> {
			try {
				threadSimulator.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		changeState(threadSimulator, new RunningState());
		changeState(threadSimulator, new WaitingState(threadSimulator));
		changeState(threadSimulator, new TerminatedState());

		executorService.shutdown();

	}

	private static void changeState(ThreadSimulator threadSimulator, ThreadState state) throws InterruptedException {
		Thread.sleep(3000L);
		System.out.println("CHANGE STATE TO: " + state.getClass());
		threadSimulator.setThreadState(state);
	}
}
