package com.budaev.rest.async;

import com.budaev.http.GithubV3MediaType;
import com.budaev.http.model.GithubOrganization;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.AsyncClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;

import java.util.Collections;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class GithubTemplateAsyncClient {

	private final AsyncRestTemplate restTemplate;

	public GithubTemplateAsyncClient(int connectTimeout) {
		this.restTemplate = new AsyncRestTemplate(getClientHttpRequestFactory(connectTimeout));
	}

	public ListenableFuture<ResponseEntity<GithubOrganization[]>> getUserOrganizations(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(AUTHORIZATION, "token " + token);
		headers.setAccept(Collections.singletonList(GithubV3MediaType.GITHUB_V3_MEDIA_TYPE));
		HttpEntity<String> getEntity = new HttpEntity<>(headers);
		return restTemplate.exchange("https://api.github.com/user/orgs",
				HttpMethod.GET,
				getEntity,
				GithubOrganization[].class
		);

	}

	private AsyncClientHttpRequestFactory getClientHttpRequestFactory(int timeout) {
		SimpleClientHttpRequestFactory clientHttpRequestFactory
				= new SimpleClientHttpRequestFactory();
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(5);
		threadPoolTaskExecutor.setMaxPoolSize(5);
		threadPoolTaskExecutor.initialize();
		clientHttpRequestFactory.setTaskExecutor(threadPoolTaskExecutor);
		clientHttpRequestFactory.setConnectTimeout(timeout);
		return clientHttpRequestFactory;
	}
}
