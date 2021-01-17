package behavioral.strategy.surface;

import behavioral.strategy.movement.MoveState;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public interface Surface {

	boolean supports(MoveState moveState);

}
