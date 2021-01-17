package com.budaev.http;

import org.springframework.http.MediaType;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class GithubV3MediaType extends MediaType {

	public static GithubV3MediaType GITHUB_V3_MEDIA_TYPE = new GithubV3MediaType("application", "vnd.github.v3+json");

	public GithubV3MediaType(String type, String subtype) {
		super(type, subtype);
	}
}
