package com.budaev.spring.core.ioc.annotation;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class AnnotationApplicationContextLauncher {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		final MyBean bean = applicationContext.getBean(MyBean.class);

		applicationContext.publishEvent(new ApplicationEvent("hello") {
			@Override
			public Object getSource() {
				return super.getSource();
			}
		});

		applicationContext.publishEvent(new ApplicationEvent("hello") {
			@Override
			public Object getSource() {
				return super.getSource();
			}
		});


	}
}
