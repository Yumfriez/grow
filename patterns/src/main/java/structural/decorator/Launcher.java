package structural.decorator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Launcher {
	public static final String ROOT_PATH = "./patterns";
	public static final String FILE_NAME = "hello.txt";
	public static final String FILE_NAME_TO_ENCRYPT = "hello1.txt";

	public static void main(String[] args) {

		FileStorage fileStorage = new BasicFileStorage(ROOT_PATH);
		fileStorage.save(getResource(), FILE_NAME);

		FileStorage encrypted = new EncryptedFilenameDecorator(new EncryptedContentDecorator(fileStorage));

		final String name = encrypted.save(getResource(), FILE_NAME_TO_ENCRYPT);

		final Base64.Decoder decoder = Base64.getDecoder();
		System.out.println("ENCODED: " + name + " DECODED: " + new String(decoder.decode(name)));

		try (final InputStream inputStream = encrypted.load(FILE_NAME_TO_ENCRYPT)) {
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
