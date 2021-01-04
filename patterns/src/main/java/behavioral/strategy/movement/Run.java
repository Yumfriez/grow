package behavioral.strategy.movement;

import behavioral.strategy.surface.Surface;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Run implements MoveState {
	@Override
	public void move(Surface surface) {
		if (surface.supports(this)) {
			System.out.println("Running...");
		} else {
			System.out.println("Unable to run");
		}
	}
}
