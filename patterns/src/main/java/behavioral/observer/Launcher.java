package behavioral.observer;

import java.util.List;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static void main(String[] args) {

		EventSubscriber slackNotification = message -> {
			System.out.println("Sending slack notification...");
			System.out.println("SLACK: " + message);
		};

		EventSubscriber logSaver = message -> {
			System.out.println("Save log...");
			System.out.println("LOG: " + message);
		};

		final EventListener<TravisEvent> travisEventListener = new TravisEventListener();
		travisEventListener.addSubscriber(slackNotification);
		travisEventListener.addSubscriber(logSaver);

		final EventListener<JenkinsJobEvent> jenkinsJobEventListener = new JenkinsJobEventListener();
		jenkinsJobEventListener.addSubscriber(logSaver);

		final List<EventListener<? extends Event<?>>> eventListeners = List.of(travisEventListener,
				jenkinsJobEventListener
		);
		Pipeline pipeline = new Pipeline(eventListeners);

		pipeline.start();
		pipeline.finish("FAILED");

		pipeline.start();
		pipeline.finish("PASSED");
	}
}
