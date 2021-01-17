package behavioral.observer;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@FunctionalInterface
public interface EventSubscriber {

	void handle(String action);
}
