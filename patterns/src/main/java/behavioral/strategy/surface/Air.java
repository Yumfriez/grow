package behavioral.strategy.surface;

import behavioral.strategy.movement.Fly;
import behavioral.strategy.movement.MoveState;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Air implements Surface {

	@Override
	public boolean supports(MoveState moveState) {
		return Fly.class.isAssignableFrom(moveState.getClass());
	}
}
