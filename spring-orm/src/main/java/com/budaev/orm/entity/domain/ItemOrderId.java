package com.budaev.orm.entity.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@Embeddable
public class ItemOrderId implements Serializable {

	@Column(name = "item_id")
	private Long itemId;

	@Column(name = "order_id")
	private Long orderId;

	public ItemOrderId() {
	}

	public ItemOrderId(Long itemId, Long orderId) {
		this.itemId = itemId;
		this.orderId = orderId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ItemOrderId that = (ItemOrderId) o;
		return Objects.equals(itemId, that.itemId) && Objects.equals(orderId, that.orderId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, orderId);
	}
}
