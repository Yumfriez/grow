package com.budaev.spring.core.execution;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@Configuration
@EnableScheduling
public class SchedulersConfiguration implements SchedulingConfigurer {

	@Bean
	public TaskScheduler concurrentTaskScheduler() {
		final ConcurrentTaskScheduler concurrentTaskScheduler = new ConcurrentTaskScheduler();
		concurrentTaskScheduler.setConcurrentExecutor(Executors.newFixedThreadPool(5));
		return concurrentTaskScheduler;
	}

	@Bean
	public TaskScheduler threadPoolTaskScheduler() {
		final ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setPoolSize(5);
		threadPoolTaskScheduler.setThreadGroupName("TPS");
		threadPoolTaskScheduler.setWaitForTasksToCompleteOnShutdown(true);
		return threadPoolTaskScheduler;
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setTaskScheduler(threadPoolTaskScheduler());
	}
}
