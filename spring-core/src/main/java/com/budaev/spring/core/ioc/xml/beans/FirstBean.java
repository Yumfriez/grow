package com.budaev.spring.core.ioc.xml.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class FirstBean implements MyBean, InitializingBean, DisposableBean {

	public FirstBean() {
		System.out.println("First constructor");
	}

	@Override
	public void print() {
		System.out.println("I am first");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("First init");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("First destroyed");
	}

	public static class FirstNestedBean {

	}
}
