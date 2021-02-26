package com.budaev.orm.entity.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@Entity
@Table(name = "item_order")
public class ItemOrder implements Serializable {

	@EmbeddedId
	private ItemOrderId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("item_id")
	private Item item;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("order_id")
	private Order order;

	public ItemOrder() {
	}

	public ItemOrder(Item item, Order order) {
		this.item = item;
		this.order = order;
		this.id = new ItemOrderId(item.getId(), order.getId());
	}

	public ItemOrderId getId() {
		return id;
	}

	public void setId(ItemOrderId id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ItemOrder itemOrder = (ItemOrder) o;
		return Objects.equals(id, itemOrder.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
