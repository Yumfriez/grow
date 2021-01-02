package behavioral.chain.assembler;

import behavioral.chain.entity.Leg;
import behavioral.chain.entity.Robot;

import java.util.List;
import java.util.Set;

import static java.util.Optional.ofNullable;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class LegAssembler extends AbstractRobotAssembler {
	@Override
	protected Robot doAssemble(Robot robot, Set<String> params) {
		if (params.contains("leg")) {
			ofNullable(robot.getBody()).ifPresent(b -> robot.setLegs(List.of(new Leg(), new Leg())));
		}
		return robot;
	}
}
