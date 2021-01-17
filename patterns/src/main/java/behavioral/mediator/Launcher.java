package behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse(List.of(new Loader(), new Loader()), new Keeper());

		final Truck truck = new Truck();
		truck.setItems(new ArrayList<>(List.of(new Item("fish"), new Item("vegetables"))));

		truck.unloadItems(warehouse);
	}
}
