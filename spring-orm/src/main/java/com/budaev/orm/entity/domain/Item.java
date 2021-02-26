package com.budaev.orm.entity.domain;

import com.budaev.orm.entity.listener.ItemListener;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@EntityListeners(value = ItemListener.class)
@Entity
@Table(name = "item")
public class Item implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private BigDecimal price;

	@Version
	private int version;

	public Item() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getVersion() {
		System.out.println("GET VERSION: " + version);
		return version;
	}

	public void setVersion(int version) {
		System.out.println("SET VERSION: " + version);
		this.version = version;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Item item = (Item) o;

		if (this.id != null && item.id != null) {
			return this.id.equals(item.getId());
		}

		return Objects.equals(name, item.name) && Objects.equals(price, item.price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, price);
	}
}
