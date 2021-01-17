package com.budaev.spring.aop.service;

import com.budaev.spring.aop.aspect.annotation.Tracker;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@Component
public class HumanServiceImpl implements HumanService {

	@Override
	@Tracker
	public void walk() {
		System.out.println("I'm walking...");
	}

	@Override
	@Tracker
	public void speak() {
		System.out.println("I'm speaking...");
	}

	@Override
	@Tracker(enabled = false)
	public void eat() {
		System.out.println("I'm eating...");
	}
}
