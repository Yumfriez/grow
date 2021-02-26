package com.budaev.orm.entity.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "creation_date")
	private Instant creationDate;

	@Column(name = "state")
	private String state;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemOrder> items = new ArrayList<>();

	public Order() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ItemOrder> getItems() {
		return items;
	}

	public void setItems(List<ItemOrder> items) {
		this.items = items;
	}

	public void addItem(Item item) {
		ItemOrder itemOrder = new ItemOrder(item, this);
		items.add(itemOrder);
	}

	public void removeItem(Item item) {
		for (Iterator<ItemOrder> iterator = items.iterator(); iterator.hasNext(); ) {
			ItemOrder itemOrder = iterator.next();
			if (this.equals(itemOrder.getOrder()) && item.equals(itemOrder.getItem())) {
				iterator.remove();
				itemOrder.setItem(null);
				itemOrder.setOrder(null);
			}
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Order order = (Order) o;

		if (this.id != null && order.id != null) {
			return this.id.equals(order.getId());
		}

		return Objects.equals(creationDate, order.creationDate) && Objects.equals(state, order.state) && Objects.equals(user, order.user);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, creationDate, state, user);
	}
}
