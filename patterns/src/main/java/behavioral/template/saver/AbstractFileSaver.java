package behavioral.template.saver;

import java.io.*;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public abstract class AbstractFileSaver implements FileSaver {

	abstract void save(String fileName, InputStream inputStream) throws IOException;

	@Override
	public void save(File file) throws IOException {
		validateExistence(file);
		try (InputStream inputStream = new FileInputStream(file)) {
			save(file.getName(), inputStream);
		}
	}

	private void validateExistence(File file) throws FileNotFoundException {
		if (!file.exists()) {
			throw new FileNotFoundException(file.getName());
		}
	}
}
