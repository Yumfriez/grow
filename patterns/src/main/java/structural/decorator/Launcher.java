package structural.decorator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static void main(String[] args) {
		FileStorage fileStorage = new BasicFileStorage("./patterns");
		fileStorage.save(getResource(), "hello.txt");

		FileStorage encrypted = new EncryptedFilenameDecorator(new EncryptedContentDecorator(fileStorage));
		final String name = encrypted.save(getResource(), "hello1.txt");
		final Base64.Decoder decoder = Base64.getDecoder();
		System.out.println("ENCODED: " + name + " DECODED: " + new String(decoder.decode(name)));
		try (final InputStream inputStream = encrypted.load("hello1.txt")) {
			final String content = new String(inputStream.readAllBytes());
			System.out.println(content);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static InputStream getResource() {
		return Launcher.class.getResourceAsStream("/hello.txt");
	}

}
