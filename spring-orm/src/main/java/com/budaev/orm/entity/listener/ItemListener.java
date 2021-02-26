package com.budaev.orm.entity.listener;

import com.budaev.orm.entity.domain.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class ItemListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(ItemListener.class);

	@PrePersist
	private void beforePersist(Item item) {
		LOGGER.info("BEFORE PERSIST EVENT...");
	}

	@PreUpdate
	private void beforeUpdate(Item item) {
		LOGGER.info("BEFORE UPDATE EVENT...");
	}

	@PreRemove
	private void beforeRemove(Item item) {
		LOGGER.info("BEFORE REMOVE EVENT... " + item.getId());
	}

	@PostPersist
	private void afterPersist(Item item) {
		LOGGER.info("AFTER PERSIST EVENT...");
	}

	@PostUpdate
	private void afterUpdate(Item item) {
		LOGGER.info("AFTER UPDATE EVENT...");
	}

	@PostRemove
	private void afterRemove(Item item) {
		LOGGER.info("AFTER REMOVE EVENT... " + item.getId());
	}

	@PostLoad
	private void afterLoad(Item item) {
		LOGGER.info("AFTER LOAD EVENT...");
	}
}
