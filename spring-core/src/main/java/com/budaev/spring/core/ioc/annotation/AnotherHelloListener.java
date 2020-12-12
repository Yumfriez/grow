package com.budaev.spring.core.ioc.annotation;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
@Component
public class AnotherHelloListener {

	@EventListener
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("Another: " + event.getSource());
	}
}
