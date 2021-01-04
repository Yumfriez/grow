package behavioral.strategy;

import behavioral.strategy.movement.MoveState;
import behavioral.strategy.surface.Surface;

import java.util.Map;
import java.util.Optional;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class DefaultMoveStateResolver implements MoveStateResolver {

	private final Map<Class<? extends Surface>, MoveState> moveStateMapping;

	public DefaultMoveStateResolver(Map<Class<? extends Surface>, MoveState> moveStateMapping) {
		this.moveStateMapping = moveStateMapping;
	}

	@Override
	public Optional<MoveState> resolve(Surface surface) {
		return Optional.ofNullable(moveStateMapping.get(surface.getClass())).filter(surface::supports);
	}
}
