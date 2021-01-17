package structural.composite;

import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static void main(String[] args) {
		Directory usersDir = new Directory("users", Paths.get("/"));
		Directory myUserDir = new Directory("myUser", usersDir.getPath());
		usersDir.addComponent(myUserDir);

		File imageFile = new File(1000, "image.png", usersDir.getPath());
		usersDir.addComponent(imageFile);

		Stream.generate(() -> new File(100, "file" + new Random().nextInt() + ".txt", myUserDir.getPath()))
				.limit(5)
				.forEach(myUserDir::addComponent);

		printSize(myUserDir);
		printSize(imageFile);
		printSize(usersDir);
	}

	public static void printSize(FileSystemComponent component) {
		System.out.println(component.getName() + " " + component.getSize());
	}
}
