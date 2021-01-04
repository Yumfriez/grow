package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class TravisEventListener implements EventListener<TravisEvent> {

	private final List<EventSubscriber> eventSubscribers;

	public TravisEventListener() {
		eventSubscribers = new ArrayList<>();
	}

	public TravisEventListener(List<EventSubscriber> eventSubscribers) {
		this.eventSubscribers = eventSubscribers;
	}

	@Override
	public boolean supports(Class<? extends Event> eventType) {
		return TravisEvent.class.isAssignableFrom(eventType);
	}

	@Override
	public void onEvent(Event<?> event) {
		final TravisEvent travisEvent = (TravisEvent) event;
		eventSubscribers.forEach(s -> s.handle("Travis build status: " + event.getSource()));
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
