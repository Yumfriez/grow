package com.budaev.spring.aop.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@Configuration
public class AspectConfig {

	@Bean
	public SimpleAspect simpleAspect() {
		return new SimpleAspect();
	}
}
