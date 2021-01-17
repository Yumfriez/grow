package behavioral.mediator;

import java.util.List;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Keeper {

	private Warehouse warehouse;

	public Keeper() {
	}

	public void addNotes(List<Item> items) {
		warehouse.registerNewItems(items);
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
}
