package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class JenkinsJobEventListener implements EventListener<JenkinsJobEvent> {

	private final List<EventSubscriber> eventSubscribers;

	public JenkinsJobEventListener() {
		eventSubscribers = new ArrayList<>();
	}

	public JenkinsJobEventListener(List<EventSubscriber> eventSubscribers) {
		this.eventSubscribers = eventSubscribers;
	}

	@Override
	public boolean supports(Class<? extends Event> eventType) {
		return JenkinsJobEvent.class.isAssignableFrom(eventType);
	}

	@Override
	public void onEvent(Event<?> event) {
		final JenkinsJobEvent jenkinsJobEvent = (JenkinsJobEvent) event;
		eventSubscribers.forEach(s -> s.handle("Jenkins job finish time: " + event.getSource()));
	}

	@Override
	public void addSubscriber(EventSubscriber subscriber) {
		eventSubscribers.add(subscriber);
	}

	@Override
	public void removeSubscriber(EventSubscriber subscriber) {
		eventSubscribers.remove(subscriber);
	}
}
