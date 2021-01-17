package creational.method;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class FileSystemFileLoader implements FileLoader {
	@Override
	public InputStream load(String path) throws FileNotFoundException {
		return new FileInputStream(path);
	}
}
