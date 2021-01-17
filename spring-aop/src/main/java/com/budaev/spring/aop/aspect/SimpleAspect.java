package com.budaev.spring.aop.aspect;

import com.budaev.spring.aop.aspect.annotation.Tracker;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@Aspect
public class SimpleAspect {

	@Pointcut(value = "execution(public * *(..))")
	public void anyPublicMethod() {
	}

	@Pointcut(value = "within(com.budaev.spring.aop.service..*)")
	public void inEntity() {
	}

	@Pointcut(value = "anyPublicMethod() && inEntity() && @annotation(trackerAnnotation)")
	public void entityOperation(Tracker trackerAnnotation) {
	}

	@Around(value = "entityOperation(trackerAnnotation)", argNames = "joinPoint,trackerAnnotation")
	public Object trackOperation(ProceedingJoinPoint joinPoint, Tracker trackerAnnotation) throws Throwable {
		if (trackerAnnotation.enabled()) {
			System.out.println();
			System.out.println("Tracking action: " + ((MethodSignature) joinPoint.getSignature()).getMethod().getName());
		}
		return joinPoint.proceed();
	}
}
