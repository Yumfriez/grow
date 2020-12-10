package com.budaev.spring.core.cache.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
@SpringBootApplication(scanBasePackages = { "com.budaev.spring.core.cache.boot", "com.budaev.spring.core.cache.common" })
public class CacheSpringBootLauncher {

	public static void main(String[] args) {
		SpringApplication.run(CacheSpringBootLauncher.class, args);
	}
}
