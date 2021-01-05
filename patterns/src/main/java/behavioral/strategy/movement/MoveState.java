package behavioral.strategy.movement;

import behavioral.strategy.surface.Surface;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public interface MoveState {

	void move(Surface surface);
}
