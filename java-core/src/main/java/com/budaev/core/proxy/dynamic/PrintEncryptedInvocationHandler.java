package com.budaev.core.proxy.dynamic;

import com.budaev.core.proxy.service.PrintService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class PrintEncryptedInvocationHandler implements InvocationHandler {

	private final PrintService target;

	public PrintEncryptedInvocationHandler(PrintService target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		final String line = (String) args[0];
		args[0] = Base64.getEncoder().encodeToString(line.getBytes(StandardCharsets.UTF_8));
		return method.invoke(target, args);
	}
}
