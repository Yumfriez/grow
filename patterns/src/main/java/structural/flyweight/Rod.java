package structural.flyweight;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Rod {

	private final RodType rodType;
	private int remainedCapacity;

	public Rod(RodType rodType) {
		this.rodType = rodType;
		this.remainedCapacity = rodType.getInkCapacity();
	}

	public RodType getRodType() {
		return rodType;
	}

	public int getRemainedCapacity() {
		return remainedCapacity;
	}

	public void setRemainedCapacity(int remainedCapacity) {
		this.remainedCapacity = remainedCapacity;
	}
}
