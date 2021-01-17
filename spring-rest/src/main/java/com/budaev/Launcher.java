package com.budaev;

import com.budaev.http.model.GithubOrganization;
import com.budaev.rest.GithubTemplateClient;
import com.budaev.rest.async.GithubTemplateAsyncClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.HttpClientErrorException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static void main(String[] args) {

		try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Enter github token");
			proceedSync(bufferedReader.readLine());

			System.out.println("Enter github token for async processing");
			proceedAsync(bufferedReader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void proceedSync(String token) {
		final GithubTemplateClient templateClient = new GithubTemplateClient(5000);
		final List<GithubOrganization> userOrganizations = templateClient.getUserOrganizations(token);
		userOrganizations.forEach(System.out::println);
	}

	private static void proceedAsync(String token) {
		final GithubTemplateAsyncClient templateAsyncClient = new GithubTemplateAsyncClient(5000);

		final ListenableFuture<ResponseEntity<GithubOrganization[]>> userOrganizations = templateAsyncClient.getUserOrganizations(token);
		final CompletableFuture<ResponseEntity<GithubOrganization[]>> completable = userOrganizations.completable();

		final CompletableFuture<Void> resultCompletable = completable.thenAccept(response -> {
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				ofNullable(response.getBody()).map(organizations -> Stream.of(organizations).collect(toList()))
						.ifPresent(organizations -> organizations.forEach(System.out::println));
			} else {
				throw new HttpClientErrorException(response.getStatusCode());
			}
		});
		resultCompletable.join();
	}
}
