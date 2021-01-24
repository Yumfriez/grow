package com.budaev.batch.entity.user;

import java.io.Serializable;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class User implements Serializable {

	private Long id;
	private String login;
	private String password;

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", login='" + login + '\'' + ", password='" + password + '\'' + '}';
	}
}
