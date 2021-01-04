package behavioral.observer;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
@FunctionalInterface
public interface EventSubscriber {

	void handle(String action);
}
