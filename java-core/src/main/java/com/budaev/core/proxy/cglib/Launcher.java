package com.budaev.core.proxy.cglib;

import com.budaev.core.proxy.service.PrintServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static void main(String[] args) {
		final Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(PrintServiceImpl.class);
		enhancer.setCallback((MethodInterceptor) (obj, method, arguments, proxy) -> {
			System.out.println("CGLib proxy logic");
			return Optional.empty();
		});
		enhancer.setCallbackFilter(method -> 0);

		final PrintServiceImpl printServiceProxy = (PrintServiceImpl) enhancer.create();
		printServiceProxy.print("Hello world");

		enhancer.setCallback((MethodInterceptor) (obj, method, arguments, proxy) -> {
			final String line = (String) arguments[0];
			arguments[0] = Base64.getEncoder().encodeToString(line.getBytes(StandardCharsets.UTF_8));
			return proxy.invokeSuper(obj, arguments);
		});

		final PrintServiceImpl printEncryptedServiceProxy = (PrintServiceImpl) enhancer.create();
		printEncryptedServiceProxy.print("Hello world");

	}
}
