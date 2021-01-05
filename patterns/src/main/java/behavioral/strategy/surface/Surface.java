package behavioral.strategy.surface;

import behavioral.strategy.movement.MoveState;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public interface Surface {

	boolean supports(MoveState moveState);

}
