package com.budaev.spring.core.ioc.annotation.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class CustomEvent<T> extends ApplicationEvent implements ResolvableTypeProvider {

	private T source;

	public CustomEvent(T source) {
		super(source);
	}

	@Override
	public ResolvableType getResolvableType() {
		return ResolvableType.forClassWithGenerics(this.getClass(), ResolvableType.forInstance(source));
	}
}
