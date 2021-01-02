package behavioral.chain.assembler;

import behavioral.chain.entity.Robot;

import java.util.Set;

import static java.util.Optional.ofNullable;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public abstract class AbstractRobotAssembler implements RobotAssembler {

	private RobotAssembler nextAssembler;

	public AbstractRobotAssembler() {
	}

	public AbstractRobotAssembler(RobotAssembler nextAssembler) {
		this.nextAssembler = nextAssembler;
	}

	protected abstract Robot doAssemble(Robot robot, Set<String> params);

	@Override
	public Robot assemble(Robot robot, Set<String> params) {
		final Robot updatedRobot = doAssemble(robot, params);
		return ofNullable(nextAssembler).map(a -> a.assemble(updatedRobot, params)).orElse(updatedRobot);
	}

	@Override
	public void setNextAssembler(RobotAssembler assembler) {
		this.nextAssembler = assembler;
	}
}
