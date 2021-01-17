package behavioral.strategy.movement;

import behavioral.strategy.surface.Surface;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public interface MoveState {

	void move(Surface surface);
}
