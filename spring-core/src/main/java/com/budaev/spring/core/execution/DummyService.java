package com.budaev.spring.core.execution;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@Service
public class DummyService {

	@Async
	public void printThread() {
		System.out.println(Thread.currentThread().getThreadGroup().getName() + " " + Thread.currentThread().getName());
	}

	@Scheduled(fixedRate = 500L)
	public void scheduledPrint() {
		System.out.println(Thread.currentThread().getThreadGroup().getName() + " " + Thread.currentThread().getName());
	}
}
