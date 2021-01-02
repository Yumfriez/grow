package behavioral.chain;

import behavioral.chain.assembler.*;
import behavioral.chain.entity.Robot;

import java.util.Set;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static void main(String[] args) {
		final LegAssembler legAssembler = new LegAssembler();
		final ArmAssembler armAssembler = new ArmAssembler();
		final HeadAssembler headAssembler = new HeadAssembler();
		final EngineAssembler engineAssembler = new EngineAssembler();
		final BodyAssembler bodyAssembler = new BodyAssembler();

		legAssembler.setNextAssembler(armAssembler);
		headAssembler.setNextAssembler(legAssembler);
		engineAssembler.setNextAssembler(headAssembler);
		bodyAssembler.setNextAssembler(engineAssembler);

		final Set<String> fullRobotParams = Set.of("body", "engine", "head", "leg", "arm");

		final Robot firstRobot = bodyAssembler.assemble(new Robot(), fullRobotParams);
		firstRobot.walk();
		firstRobot.punch();

		final Set<String> noArmsParams = Set.of("body", "engine", "head", "leg");
		final Robot secondRobot = bodyAssembler.assemble(new Robot(), noArmsParams);
		secondRobot.walk();
		secondRobot.punch();

	}
}
