package com.budaev.orm.service.item;

import com.budaev.orm.entity.domain.Item;
import com.budaev.orm.jpa.repository.item.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@Service
public class ItemLifecycleSimulator {

	private static final Logger LOGGER = LoggerFactory.getLogger(ItemLifecycleSimulator.class);
	private final TransactionTemplate transactionTemplate;
	private final ItemRepository itemRepository;

	@Autowired
	public ItemLifecycleSimulator(PlatformTransactionManager transactionManager, ItemRepository itemRepository) {
		this.transactionTemplate = new TransactionTemplate(transactionManager);
		this.itemRepository = itemRepository;
	}

	/**
	 * Transaction template allows to manipulate multiple transaction scopes within one method
	 */
	public void simulate() {
		LOGGER.info("----CREATION SIMULATION---");
		creationSimulation();
		LOGGER.info("----CREATION SIMULATION---\n");

		LOGGER.info("----POST CREATE SIMULATION---");
		postCreateLifecycleSimulation();
		LOGGER.info("----POST CREATE SIMULATION---\n");
	}

	private void creationSimulation() {
		transactionTemplate.executeWithoutResult(s -> {
			Item item = new Item();
			item.setName("item");
			item.setPrice(BigDecimal.valueOf(12345));

			LOGGER.info("SAVING ITEM...");
			itemRepository.save(item);
			LOGGER.info("ITEM SAVED...");

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			LOGGER.info("TRANSACTION COMMIT EXPECTED...");
		});

	}

	private void postCreateLifecycleSimulation() {
		transactionTemplate.executeWithoutResult(s -> {

			LOGGER.info("LOADING ITEMS...");
			final List<Item> items = itemRepository.findAll();
			LOGGER.info("ITEMS LOADED...");

			LOGGER.info("UPDATING ITEMS...");
			items.forEach(i -> i.setName("changed name"));
			LOGGER.info("ITEMS UPDATED...");

			LOGGER.info("REMOVING ITEM...");
			final Item toRemove = items.stream().findFirst().get();
			itemRepository.delete(toRemove);
			LOGGER.info("ITEM REMOVED...");

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			LOGGER.info("TRANSACTION COMMIT EXPECTED...");
		});

	}
}
