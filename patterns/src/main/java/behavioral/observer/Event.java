package behavioral.observer;

import java.io.Serializable;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public interface Event<T> extends Serializable {

	T getSource();

}
