package behavioral.chain.assembler;

import behavioral.chain.entity.Robot;

import java.util.Set;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public interface RobotAssembler {

	Robot assemble(Robot robot, Set<String> params);

	void setNextAssembler(RobotAssembler assembler);
}
