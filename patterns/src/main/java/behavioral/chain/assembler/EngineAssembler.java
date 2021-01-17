package behavioral.chain.assembler;

import behavioral.chain.entity.Body;
import behavioral.chain.entity.Robot;

import java.util.Set;

import static java.util.Optional.ofNullable;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class EngineAssembler extends AbstractRobotAssembler {
	@Override
	protected Robot doAssemble(Robot robot, Set<String> params) {
		if (params.contains("engine")) {
			ofNullable(robot.getBody()).ifPresent(b -> b.setEngine(new Body.Engine("Mark-II")));
		}
		return robot;
	}

}
