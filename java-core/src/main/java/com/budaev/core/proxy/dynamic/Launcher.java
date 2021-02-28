package com.budaev.core.proxy.dynamic;

import com.budaev.core.proxy.service.PrintService;
import com.budaev.core.proxy.service.PrintServiceImpl;

import java.lang.reflect.Proxy;
import java.util.Optional;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static void main(String[] args) {

		final PrintService printServiceProxy = (PrintService) Proxy.newProxyInstance(Launcher.class.getClassLoader(),
				new Class[] { PrintService.class },
				(p, m, arguments) -> {
					System.out.println(p.getClass());
					System.out.println("Only proxy logic executed");
					return Optional.empty();
				}
		);
		printServiceProxy.print("Hello world");

		final PrintService printService = new PrintServiceImpl();
		printService.print("Hello world");

		final PrintService printEncryptedServiceProxy = (PrintService) Proxy.newProxyInstance(Launcher.class.getClassLoader(),
				new Class[] { PrintService.class },
				new PrintEncryptedInvocationHandler(printService)
		);

		printEncryptedServiceProxy.print("Hello world");

	}
}
