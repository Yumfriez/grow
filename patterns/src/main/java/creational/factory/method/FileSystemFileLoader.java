package creational.factory.method;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class FileSystemFileLoader implements FileLoader {
	@Override
	public InputStream load(String path) throws FileNotFoundException {
		return new FileInputStream(path);
	}
}
