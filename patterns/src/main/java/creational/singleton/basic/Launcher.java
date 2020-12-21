package creational.singleton.basic;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static final String FILE_NAME = "store.ser";

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		enumSingleton();
		staticFieldSingleton();
	}

	private static void enumSingleton() throws IOException, ClassNotFoundException {
		//If file already exists with serialized enum - don't init enum with value
		//so when it will be deserialized `value` field will be null
		if (Files.notExists(Paths.get(FILE_NAME))) {
			final EnumSingleton instance = EnumSingleton.getInstance();
			instance.setValue("hello");
			System.out.println(instance.getValue());

			try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME, false))) {
				objectOutputStream.writeObject(instance);
			}
		}

		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
			EnumSingleton enumSingleton = (EnumSingleton) objectInputStream.readObject();
			System.out.println(enumSingleton.getValue());
		}
	}

	private static void staticFieldSingleton() {
		final StaticFieldSingleton instance = StaticFieldSingleton.getInstance();
		instance.setName("name");
		System.out.println(StaticFieldSingleton.getInstance().getName());
	}
}
