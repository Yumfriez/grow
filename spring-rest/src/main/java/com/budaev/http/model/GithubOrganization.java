package com.budaev.http.model;

import java.io.Serializable;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class GithubOrganization implements Serializable {

	private Long id;
	private String login;
	private String description;
	private String url;

	public GithubOrganization() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "GithubOrganization{" + "id=" + id + ", login='" + login + '\'' + ", description='" + description + '\'' + ", url='" + url
				+ '\'' + '}';
	}
}
