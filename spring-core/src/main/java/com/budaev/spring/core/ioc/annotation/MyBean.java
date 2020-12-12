package com.budaev.spring.core.ioc.annotation;

import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class MyBean {

	private final Environment environment;

	public MyBean(Environment environment) {
		this.environment = environment;
	}

	@PostConstruct
	public void init() {
		System.out.println(environment.getProperty("key"));
	}
}
