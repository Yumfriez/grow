package com.budaev.spring.core.execution;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@EnableAsync
@Configuration
public class ExecutorsConfiguration implements AsyncConfigurer {

	@Bean
	public TaskExecutor syncTaskExecutor() {
		return new SyncTaskExecutor();
	}

	@Bean
	public TaskExecutor simpleAsyncTaskExecutor() {
		final SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();
		simpleAsyncTaskExecutor.setConcurrencyLimit(5);
		simpleAsyncTaskExecutor.setThreadGroup(new ThreadGroup("SA"));
		simpleAsyncTaskExecutor.setThreadNamePrefix("sa-t-");
		return simpleAsyncTaskExecutor;
	}

	@Bean
	public TaskExecutor concurrentTaskExecutor() {
		return new ConcurrentTaskExecutor(Executors.newFixedThreadPool(3));
	}

	@Bean
	public TaskExecutor threadPoolTaskExecutor() {
		final ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(10);
		threadPoolTaskExecutor.setMaxPoolSize(20);
		threadPoolTaskExecutor.setQueueCapacity(100);
		threadPoolTaskExecutor.setThreadGroupName("TPE");
		threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
		return threadPoolTaskExecutor;
	}

	@Override
	public Executor getAsyncExecutor() {
		return threadPoolTaskExecutor();
	}
}
