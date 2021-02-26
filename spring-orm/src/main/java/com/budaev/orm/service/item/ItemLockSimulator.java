package com.budaev.orm.service.item;

import com.budaev.orm.entity.domain.Item;
import com.budaev.orm.jpa.repository.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityNotFoundException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@Service
public class ItemLockSimulator {

	private final TransactionTemplate transactionTemplate;
	private final ItemRepository itemRepository;

	@Autowired
	public ItemLockSimulator(TransactionTemplate transactionTemplate, ItemRepository itemRepository) {
		this.transactionTemplate = transactionTemplate;
		this.itemRepository = itemRepository;
	}

	public void simulate(Long id) {

		new Thread(() -> {
			try {
				updateName(id);
			} catch (ObjectOptimisticLockingFailureException ex) {
				System.out.println("First block optimistic lock exception. Retrying...");
				updateName(id);
			}
		}).start();

		new Thread(() -> {
			try {
				updateName(id);
			} catch (ObjectOptimisticLockingFailureException ex) {
				System.out.println("Second block optimistic lock exception. Retrying...");
				updateName(id);
			}
		}).start();

	}

	private void updateName(Long id) {

		transactionTemplate.executeWithoutResult(s -> {
			final Item item = itemRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item not found"));
			final int value = new Random().nextInt();
			System.out.println(Thread.currentThread().getName() + " " + value);
			item.setName(String.valueOf(value));
			try {
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
}
