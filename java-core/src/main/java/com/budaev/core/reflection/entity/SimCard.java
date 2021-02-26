package com.budaev.core.reflection.entity;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class SimCard implements InternetProvider {

	private final String id;

	public SimCard(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
