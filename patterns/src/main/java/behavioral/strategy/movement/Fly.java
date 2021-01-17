package behavioral.strategy.movement;

import behavioral.strategy.surface.Surface;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Fly implements MoveState {

	@Override
	public void move(Surface surface) {
		if (surface.supports(this)) {
			System.out.println("Flying...");
		} else {
			System.out.println("Unable to fly");
		}
	}
}
