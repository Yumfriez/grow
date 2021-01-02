package behavioral.mediator;

import java.util.List;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Loader {

	private Warehouse warehouse;
	private boolean free = true;

	public Loader() {
	}

	public void loadItems(List<Item> items) {
		warehouse.addItems(items);
		items.clear();
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}
}
