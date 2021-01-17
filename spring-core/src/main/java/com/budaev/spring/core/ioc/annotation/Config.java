package com.budaev.spring.core.ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@Configuration
@PropertySource(value = "classpath:example.properties")
@ComponentScan(basePackages = "com.budaev.spring.core.ioc.annotation")
public class Config {

	private final Environment environment;

	@Autowired
	public Config(Environment environment) {
		this.environment = environment;
	}

	@Bean
	public MyBean myBean() {
		return new MyBean(environment);
	}

	@Bean
	public ApplicationListener<ApplicationEvent> eventListener() {
		return new HelloListener();
	}
}
