package behavioral.strategy;

import behavioral.strategy.movement.MoveState;
import behavioral.strategy.surface.Surface;

import static java.util.Optional.ofNullable;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Robot {

	private final MoveStateResolver moveStateResolver;
	private MoveState moveState;

	public Robot(MoveStateResolver moveStateResolver) {
		this.moveStateResolver = moveStateResolver;
	}

	public void move(Surface surface) {
		ofNullable(this.moveState).ifPresentOrElse(ms -> {
		}, () -> {
			System.out.println("Unresolved move state. Trying to resolve...");
			moveStateResolver.resolve(surface).ifPresentOrElse(m -> {
				System.out.println("Changing moving state...");
				this.moveState = m;
			}, () -> System.out.println("Unable to resolve move state"));
		});

		ofNullable(this.moveState).ifPresent(ms -> {
			if (surface.supports(moveState)) {
				moveState.move(surface);
			} else {
				System.out.println("Can't move");
				moveStateResolver.resolve(surface).ifPresent(m -> {
					System.out.println("Changing moving state...");
					this.moveState = m;
				});
			}
		});
	}

	public MoveState getMoveState() {
		return moveState;
	}

	public void setMoveState(MoveState moveState) {
		this.moveState = moveState;
	}
}
