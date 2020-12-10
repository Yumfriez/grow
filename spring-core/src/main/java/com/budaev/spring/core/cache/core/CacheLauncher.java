package com.budaev.spring.core.cache.core;

import com.budaev.spring.core.cache.common.DummyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class CacheLauncher {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(CachingConfiguration.class,
				DummyService.class
		);

		final DummyService bean = applicationContext.getBean(DummyService.class);

		final String key = "key";
		System.out.println(bean.getDummy(key));
		System.out.println(bean.getDummy(key));

		bean.addDummy(key, "I'm dummy");
		System.out.println(bean.getDummy(key));

		bean.removeDummy(key);
		System.out.println(bean.getDummy(key));

		applicationContext.close();
	}
}
