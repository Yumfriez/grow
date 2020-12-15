package com.budaev.spring.core.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
@Configuration
@ComponentScan(basePackages = "com.budaev.spring.core.mvc")
@EnableWebMvc
public class RootConfig {
}
