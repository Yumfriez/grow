package com.budaev.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@RestController
public class AsyncController {

	@RequestMapping("/async-callable")
	public Callable<String> processAsyncCallable() {

		Callable<String> callable = () -> {
			System.out.println("Doing long operation...");
			TimeUnit.SECONDS.sleep(2L);
			return "OK";
		};


		return callable;
	}

	@RequestMapping("/async-deferred")
	public DeferredResult<String> processAsyncDeferred() {

		DeferredResult<String> deferredResult = new DeferredResult<>();

		CompletableFuture.supplyAsync(() -> {
			System.out.println("Doing long operation...");
			try {
				TimeUnit.SECONDS.sleep(2L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "OK";
		}).whenCompleteAsync((result, throwable) -> deferredResult.setResult(result));

		return deferredResult;
	}

}
