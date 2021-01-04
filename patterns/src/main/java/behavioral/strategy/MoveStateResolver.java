package behavioral.strategy;

import behavioral.strategy.movement.MoveState;
import behavioral.strategy.surface.Surface;

import java.util.Optional;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public interface MoveStateResolver {

	Optional<MoveState> resolve(Surface surface);
}
