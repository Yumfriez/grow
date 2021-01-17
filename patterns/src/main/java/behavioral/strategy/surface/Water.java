package behavioral.strategy.surface;

import behavioral.strategy.movement.MoveState;
import behavioral.strategy.movement.Swim;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Water implements Surface {
	@Override
	public boolean supports(MoveState moveState) {
		return Swim.class.isAssignableFrom(moveState.getClass());
	}
}
