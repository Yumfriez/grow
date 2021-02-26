package com.budaev.orm.jpa.repository.item;

import com.budaev.orm.entity.domain.Item;
import com.budaev.orm.entity.domain.ItemOrder;
import com.budaev.orm.entity.domain.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@Repository
public class ItemRepositoryCustomImpl implements ItemRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Item> findAllByOrderId(Long orderId) {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Item> itemCriteriaQuery = criteriaBuilder.createQuery(Item.class);

		final Root<Item> itemRoot = itemCriteriaQuery.from(Item.class);
		final Root<ItemOrder> itemOrderRoot = itemCriteriaQuery.from(ItemOrder.class);
		final Root<Order> orderRoot = itemCriteriaQuery.from(Order.class);
		itemCriteriaQuery.select(itemRoot);

		final Predicate itemJoin = criteriaBuilder.equal(itemRoot.get("id"), itemOrderRoot.get("id").get("itemId"));
		final Predicate orderJoin = criteriaBuilder.equal(itemOrderRoot.get("id").get("orderId"), orderRoot.get("id"));
		final Predicate orderIdCondition = criteriaBuilder.equal(orderRoot.get("id"), orderId);

		itemCriteriaQuery.where(criteriaBuilder.and(itemJoin, orderJoin, orderIdCondition));

		final TypedQuery<Item> query = entityManager.createQuery(itemCriteriaQuery);
		return query.getResultList();
	}

	/**
	 * @return
	 * @see <a href="https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/group-by-criteria.html"></a>
	 */
	@Override
	public Map<Long, Long> findItemsWithOrdersCount() {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Tuple> groupingCriteria = criteriaBuilder.createTupleQuery();

		final Root<Item> itemRoot = groupingCriteria.from(Item.class);
		final Root<ItemOrder> itemOrderRoot = groupingCriteria.from(ItemOrder.class);
		final Root<Order> orderRoot = groupingCriteria.from(Order.class);

		final Predicate itemJoin = criteriaBuilder.equal(itemRoot.get("id"), itemOrderRoot.get("id").get("itemId"));
		final Predicate orderJoin = criteriaBuilder.equal(itemOrderRoot.get("id").get("orderId"), orderRoot.get("id"));

		final Expression<Long> groupField = itemRoot.get("id").as(Long.class);

		final CriteriaQuery<Tuple> resultSelect = groupingCriteria.multiselect(groupField, criteriaBuilder.count(groupField));

		groupingCriteria.where(criteriaBuilder.and(itemJoin, orderJoin));

		groupingCriteria.groupBy(groupField);

		return entityManager.createQuery(resultSelect)
				.getResultStream()
				.collect(Collectors.toMap(tuple -> tuple.get(0, Long.class), tuple -> tuple.get(1, Long.class)));
	}
}
