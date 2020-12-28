package structural.flyweight;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public final class RodType {

	private final String inkColor;
	private final int inkCapacity;

	private RodType(String inkColor, int inkCapacity) {
		this.inkColor = inkColor;
		this.inkCapacity = inkCapacity;
	}

	public String getInkColor() {
		return inkColor;
	}

	public int getInkCapacity() {
		return inkCapacity;
	}

	public static RodType of(String inkColor, int inkCapacity) {
		return new RodType(inkColor, inkCapacity);
	}
}
