package com.budaev.spring.core.execution;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.task.TaskExecutor;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class TaskExecutorLauncher {

	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExecutorsConfiguration.class,
				SchedulersConfiguration.class,
				DummyService.class
		);

		final TaskExecutor threadPoolTaskExecutor = applicationContext.getBean("threadPoolTaskExecutor", TaskExecutor.class);

		threadPoolTaskExecutor.execute(() -> System.out.println("Thread pool task executor execution"));

		final TaskExecutor syncTaskExecutor = applicationContext.getBean("syncTaskExecutor", TaskExecutor.class);

		syncTaskExecutor.execute(() -> {
			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println("Sync task executor execution");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		final DummyService dummyService = applicationContext.getBean(DummyService.class);
		dummyService.printThread();

		TimeUnit.SECONDS.sleep(1);
		applicationContext.close();

	}
}
