package com.budaev.orm.controller;

import com.budaev.orm.entity.domain.Item;
import com.budaev.orm.jpa.repository.item.ItemRepository;
import com.budaev.orm.service.item.ItemLifecycleSimulator;
import com.budaev.orm.service.item.ItemLockSimulator;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@RestController
@RequestMapping(value = "/item")
public class ItemController {

	private final ItemLifecycleSimulator itemLifecycleSimulator;
	private final ItemLockSimulator itemLockSimulator;
	private final ItemRepository itemRepository;

	public ItemController(ItemLifecycleSimulator itemLifecycleSimulator, ItemLockSimulator itemLockSimulator, ItemRepository itemRepository) {
		this.itemLifecycleSimulator = itemLifecycleSimulator;
		this.itemLockSimulator = itemLockSimulator;
		this.itemRepository = itemRepository;
	}

	@PostMapping
	public void createItem() {
		Item item = new Item();
		item.setName("item");
		item.setPrice(BigDecimal.valueOf(12345));

		itemRepository.save(item);
	}

	@GetMapping
	public List<Item> getItems(@RequestParam(value = "orderId") Long orderId) {
		return itemRepository.findAllByOrderId(orderId);
	}

	@GetMapping
	@RequestMapping(value = "/statistics")
	public Map<Item, Long> getItemStatistics() {
		final Map<Long, Long> itemsMapping = itemRepository.findItemsWithOrdersCount();
		final List<Item> foundItems = itemRepository.findAllById(itemsMapping.keySet());

		return foundItems.stream().collect(Collectors.toMap(item -> item, item -> itemsMapping.get(item.getId())));
	}

	@GetMapping
	@RequestMapping(value = "/lifecycle")
	public void lifeCycleSimulation() {
		itemLifecycleSimulator.simulate();
	}

	@GetMapping
	@RequestMapping(value = "/lock")
	public void lockSimulation(@RequestParam(value = "id") Long id) {
		itemLockSimulator.simulate(id);
	}

}
