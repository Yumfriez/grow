package behavioral.mediator;

import java.util.List;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Truck {

	private List<Item> items;

	public Truck() {
	}

	public void unloadItems(Warehouse warehouse) {
		warehouse.loadItems(items);
		System.out.println("Remained items count: " + items.size());
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
