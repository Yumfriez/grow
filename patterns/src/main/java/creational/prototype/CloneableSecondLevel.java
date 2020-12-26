package creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class CloneableSecondLevel extends CloneableFirstLevel {

	private String description;
	private List<String> attributes;

	public CloneableSecondLevel() {
	}

	public CloneableSecondLevel(CloneableSecondLevel secondLevel) {
		super(secondLevel);
		this.description = secondLevel.getDescription();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<String> attributes) {
		this.attributes = attributes;
	}

	@Override
	public CloneableSecondLevel clone(boolean isDeep) {
		final CloneableSecondLevel cloneableSecondLevel = new CloneableSecondLevel(this);
		if (isDeep) {
			cloneableSecondLevel.setAttributes(new ArrayList<>(this.attributes));
		} else {
			cloneableSecondLevel.setAttributes(this.attributes);
		}
		return cloneableSecondLevel;
	}
}
