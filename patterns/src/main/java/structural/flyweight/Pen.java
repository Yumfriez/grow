package structural.flyweight;

import java.util.stream.IntStream;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Pen {

	private Rod rod;

	public Pen() {
	}

	public Pen(Rod rod) {
		this.rod = rod;
	}

	public Rod getRod() {
		return rod;
	}

	public void setRod(Rod rod) {
		this.rod = rod;
	}

	public void draw() {
		IntStream.range(0, 10).forEach(i -> {
			rod.setRemainedCapacity(rod.getRemainedCapacity() - 1);
		});

	}
}
