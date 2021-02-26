package com.budaev.core.reflection;

import com.budaev.core.reflection.entity.Phone;
import com.budaev.core.reflection.entity.SimCard;
import com.budaev.core.reflection.entity.Smartphone;

import java.lang.reflect.*;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static final Integer number = 3;

	public static void main(String[] args)
			throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
		printInfo(Phone.class);
		printInfo(Smartphone.class);

		phoneSimulation();

	}

	private static void printInfo(Class<? extends Phone> phoneClass) {

		System.out.println("-----" + phoneClass.getName() + "-----");

		final Class<?>[] declaredClasses = phoneClass.getDeclaredClasses();
		final Class<?>[] classes = phoneClass.getClasses();
		final Field[] declaredFields = phoneClass.getDeclaredFields();
		final Field[] fields = phoneClass.getFields();
		final Class<?> enclosingClass = phoneClass.getEnclosingClass();
		final Method[] declaredMethods = phoneClass.getDeclaredMethods();
		final Method[] methods = phoneClass.getMethods();

		System.out.println("Declared classes: ");
		printArray(declaredClasses);

		System.out.println("Classes: ");
		printArray(classes);

		System.out.println("Declared fields: ");
		printArray(declaredFields);

		System.out.println("Fields: ");
		printArray(fields);

		System.out.println("Enclosing class: " + enclosingClass);

		System.out.println("Declared methods: ");
		printArray(declaredMethods);

		System.out.println("Methods: ");
		printArray(methods);

		System.out.println("-----" + phoneClass.getName() + "-----");
	}

	private static <T> void printArray(T... array) {
		ofNullable(array).filter(arr -> arr.length > 0).ifPresent(arr -> {
			System.out.println("[");
			Stream.of(arr).forEach(System.out::println);
			System.out.println("]");
		});
	}

	private static void phoneSimulation()
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
		final Constructor<Phone> declaredConstructor = Phone.class.getDeclaredConstructor();
		final Phone phone = declaredConstructor.newInstance();

		final SimCard simCard = SimCard.class.getDeclaredConstructor(String.class).newInstance("1234abcd");
		final Method setSimCard = phone.getClass().getDeclaredMethod("setSimCard", SimCard.class);
		setSimCard.invoke(phone, simCard);
		final Method getSimCard = phone.getClass().getDeclaredMethod("getSimCard");
		final SimCard phoneSimCard = (SimCard) getSimCard.invoke(phone);
		System.out.println(phoneSimCard.getId());

		final Method call = phone.getClass().getDeclaredMethod("call");
		call.invoke(phone);

		final Field simCardField = phone.getClass().getDeclaredField("simCard");
		simCardField.setAccessible(true);
		simCardField.set(phone, new SimCard("1q2w3e"));
		System.out.println(phone.getSimCard().getId());

		final Field id = simCard.getClass().getDeclaredField("id");
		id.setAccessible(true);
		final Field modifiers = Field.class.getDeclaredField("modifiers");
		modifiers.setAccessible(true);
		//make field non-final
		modifiers.setInt(id, simCardField.getModifiers() & ~Modifier.FINAL);
		id.set(simCard, "new id");
		System.out.println(simCard.getId());
	}
}
