package behavioral.chain.assembler;

import behavioral.chain.entity.Arm;
import behavioral.chain.entity.Robot;

import java.util.List;
import java.util.Set;

import static java.util.Optional.ofNullable;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class ArmAssembler extends AbstractRobotAssembler {
	@Override
	protected Robot doAssemble(Robot robot, Set<String> params) {
		if (params.contains("arm")) {
			ofNullable(robot.getBody()).ifPresent(b -> robot.setArms(List.of(new Arm(), new Arm())));
		}
		return robot;
	}
}
