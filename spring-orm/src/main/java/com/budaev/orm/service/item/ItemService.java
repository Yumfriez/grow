package com.budaev.orm.service.item;

import com.budaev.orm.jpa.repository.item.ItemRepository;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@Service
public class ItemService {

	private final ItemRepository itemRepository;

	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
}
