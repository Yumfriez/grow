package com.budaev.spring.core.ioc.xml;

import com.budaev.spring.core.ioc.xml.beans.BeanUser;
import com.budaev.spring.core.ioc.xml.beans.MyBean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class ApplicationContextLauncher {

	public static void main(String[] args) throws InterruptedException {

		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc/basic-config.xml");
		final Resource resource = applicationContext.getResource("ioc/basic-config.xml");
		System.out.println(resource.exists());

		final BeanUser beanUser = applicationContext.getBean("beanUser", BeanUser.class);

		beanUser.use();

		final MyBean firstBean = applicationContext.getBean("firstBean", MyBean.class);
		final MyBean secondBean = applicationContext.getBean("secondBean", MyBean.class);

		firstBean.print();
		secondBean.print();

		applicationContext.stop();
		applicationContext.close();
	}
}
