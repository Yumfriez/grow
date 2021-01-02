package behavioral.chain.assembler;

import behavioral.chain.entity.Body;
import behavioral.chain.entity.Robot;

import java.util.Set;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class BodyAssembler extends AbstractRobotAssembler {
	@Override
	protected Robot doAssemble(Robot robot, Set<String> params) {
		if (params.contains("body")) {
			robot.setBody(new Body());
		}
		return robot;
	}
}
