package behavioral.observer;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public interface EventListener<T extends Event<?>> {

	boolean supports(Class<? extends Event> eventType);

	void onEvent(Event<?> event);

	void addSubscriber(EventSubscriber subscriber);

	void removeSubscriber(EventSubscriber subscriber);
}
