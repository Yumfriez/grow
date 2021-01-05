package behavioral.strategy;

import behavioral.strategy.movement.Fly;
import behavioral.strategy.movement.MoveState;
import behavioral.strategy.movement.Run;
import behavioral.strategy.movement.Swim;
import behavioral.strategy.surface.Air;
import behavioral.strategy.surface.Ground;
import behavioral.strategy.surface.Surface;
import behavioral.strategy.surface.Water;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Application {

	public static Surface surface = new Ground();
	public static AtomicBoolean moveFlag = new AtomicBoolean(true);

	public static void main(String[] args) throws InterruptedException {

		Robot robot = new Robot(getMoveStateResolver());

		final Thread movementThread = new Thread(() -> {
			while (moveFlag.get()) {
				robot.move(surface);
				try {
					Thread.sleep(700L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		final Thread airSurfaceThread = new Thread(() -> {
			try {
				Thread.sleep(3000L);
				surface = new Air();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		final Thread waterSurfaceThread = new Thread(() -> {
			try {
				Thread.sleep(5000L);
				surface = new Water();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		movementThread.start();
		airSurfaceThread.start();
		waterSurfaceThread.start();

		Thread.sleep(10000L);

		moveFlag.set(false);
	}

	private static MoveStateResolver getMoveStateResolver() {
		final Map<Class<? extends Surface>, MoveState> moveStateMapping = new HashMap<>();
		moveStateMapping.put(Ground.class, new Run());
		moveStateMapping.put(Air.class, new Fly());
		moveStateMapping.put(Water.class, new Swim());
		return new DefaultMoveStateResolver(moveStateMapping);
	}
}
