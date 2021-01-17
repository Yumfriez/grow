package creational.method;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public abstract class AbstractFileManager implements FileManager {

	@Override
	public void copyFile(String src, String destination) {
		final FileLoader fileLoader = getFileLoader();
		try (final InputStream inputStream = fileLoader.load(src)){
			Files.copy(inputStream, Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public abstract FileLoader getFileLoader();
}
