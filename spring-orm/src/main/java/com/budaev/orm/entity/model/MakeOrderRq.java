package com.budaev.orm.entity.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class MakeOrderRq implements Serializable {

	@NotEmpty
	@JsonProperty(value = "itemIds")
	private List<Long> itemIds;

	public MakeOrderRq() {
	}

	public List<Long> getItemIds() {
		return itemIds;
	}

	public void setItemIds(List<Long> itemIds) {
		this.itemIds = itemIds;
	}
}
