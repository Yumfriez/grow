package com.budaev.rest;

import com.budaev.http.GithubV3MediaType;
import com.budaev.http.model.GithubOrganization;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class GithubTemplateClient {

	private final RestTemplate restTemplate;

	public GithubTemplateClient(int connectTimeout) {
		this.restTemplate = new RestTemplate(getClientHttpRequestFactory(connectTimeout));
	}

	public List<GithubOrganization> getUserOrganizations(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(AUTHORIZATION, "token " + token);
		headers.setAccept(Collections.singletonList(GithubV3MediaType.GITHUB_V3_MEDIA_TYPE));
		HttpEntity<String> getEntity = new HttpEntity<>(headers);
		final ResponseEntity<GithubOrganization[]> responseEntity = restTemplate.exchange("https://api.github.com/user/orgs",
				HttpMethod.GET,
				getEntity,
				GithubOrganization[].class
		);

		if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
			return ofNullable(responseEntity.getBody()).map(organizations -> Stream.of(organizations).collect(toList()))
					.orElseGet(Collections::emptyList);
		} else {
			throw new HttpClientErrorException(responseEntity.getStatusCode());
		}

	}

	private ClientHttpRequestFactory getClientHttpRequestFactory(int timeout) {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
				= new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(timeout);
		return clientHttpRequestFactory;
	}
}
