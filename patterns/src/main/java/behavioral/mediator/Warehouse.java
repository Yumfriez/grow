package behavioral.mediator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Warehouse {

	private final List<Loader> loaders;
	private final Keeper keeper;
	private final List<Item> items = new ArrayList<>();

	public Warehouse(List<Loader> loaders, Keeper keeper) {
		this.loaders = loaders;
		this.loaders.forEach(l -> l.setWarehouse(this));
		this.keeper = keeper;
		this.keeper.setWarehouse(this);
	}

	public void loadItems(List<Item> items) {
		loaders.stream().filter(Loader::isFree).findFirst().ifPresent(l -> {
			l.setFree(false);
			l.loadItems(items);
			l.setFree(true);
		});
	}

	public void addItems(List<Item> items) {
		keeper.addNotes(items);
		this.items.addAll(items);
	}

	public void registerNewItems(List<Item> items) {
		System.out.println(
				LocalDateTime.now() + " New items delivered: " + items.stream().map(Item::getName).collect(Collectors.joining(", ")));
	}
}
