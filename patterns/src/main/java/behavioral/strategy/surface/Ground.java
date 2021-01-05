package behavioral.strategy.surface;

import behavioral.strategy.movement.MoveState;
import behavioral.strategy.movement.Run;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Ground implements Surface {

	@Override
	public boolean supports(MoveState moveState) {
		return Run.class.isAssignableFrom(moveState.getClass());
	}
}
