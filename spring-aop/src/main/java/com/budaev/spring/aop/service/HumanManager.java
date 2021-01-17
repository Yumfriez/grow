package com.budaev.spring.aop.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@Service
public class HumanManager {

	private final HumanService humanService;

	public HumanManager(HumanService humanService) {
		this.humanService = humanService;
	}

	@PostConstruct
	public void useHuman() {
		humanService.walk();
		humanService.speak();
		humanService.eat();
	}
}
