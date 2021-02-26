package com.budaev.orm.jpa.repository.item;

import com.budaev.orm.entity.domain.Item;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public interface ItemRepositoryCustom {

	List<Item> findAllByOrderId(Long orderId);

	Map<Long, Long> findItemsWithOrdersCount();
}
