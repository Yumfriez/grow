package com.budaev.spring.core.ioc.xml.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class SecondBean implements MyBean {

	private final FirstBean.FirstNestedBean firstNestedBean;

	private SecondBean(FirstBean.FirstNestedBean firstNestedBean) {
		System.out.println("Second constructor");
		this.firstNestedBean = firstNestedBean;
	}

	public static SecondBean createInstance(FirstBean.FirstNestedBean firstNestedBean) {
		return new SecondBean(firstNestedBean);
	}

	@Override
	public void print() {
		System.out.println("I am second");
	}

	@PostConstruct
	public void init() {
		System.out.println("Second init");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Second destroyed");
	}
}
