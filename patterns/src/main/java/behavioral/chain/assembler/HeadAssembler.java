package behavioral.chain.assembler;

import behavioral.chain.entity.Head;
import behavioral.chain.entity.Robot;

import java.util.Set;

import static java.util.Optional.ofNullable;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class HeadAssembler extends AbstractRobotAssembler {
	@Override
	protected Robot doAssemble(Robot robot, Set<String> params) {
		if (params.contains("head")) {
			ofNullable(robot.getBody()).ifPresent(b -> robot.setHead(new Head()));
		}
		return robot;
	}
}
