package behavioral.observer;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Pipeline {

	private final List<EventListener<? extends Event<?>>> eventListeners;

	public Pipeline(List<EventListener<? extends Event<?>>> eventListeners) {
		this.eventListeners = eventListeners;
	}

	public void start() {
		System.out.println("Pipeline started...");
	}

	public void finish(String status) {
		System.out.println("Pipeline finished...");
		publishEvent(new JenkinsJobEvent(LocalDateTime.now(ZoneOffset.UTC)));
		publishEvent(new TravisEvent(status));
	}

	private void publishEvent(Event<?> event) {
		eventListeners.stream().filter(listener -> listener.supports(event.getClass())).forEach(l -> l.onEvent(event));
	}

}
