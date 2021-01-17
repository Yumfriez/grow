package com.budaev.spring.core.ioc.xml.beans;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class BeanUser {

	private final MyBean myBean;

	public BeanUser(MyBean myBean) {
		this.myBean = myBean;
	}

	public void use() {
		myBean.print();
	}
}
