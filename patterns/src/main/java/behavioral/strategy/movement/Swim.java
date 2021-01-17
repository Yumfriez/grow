package behavioral.strategy.movement;

import behavioral.strategy.surface.Surface;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Swim implements MoveState {
	@Override
	public void move(Surface surface) {
		if (surface.supports(this)) {
			System.out.println("Swimming...");
		} else {
			System.out.println("Unable to swim");
		}
	}
}
