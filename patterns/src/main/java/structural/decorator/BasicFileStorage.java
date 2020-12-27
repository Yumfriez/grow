package structural.decorator;

import java.io.*;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class BasicFileStorage implements FileStorage {

	private final String rootPath;

	public BasicFileStorage(String rootPath) {
		this.rootPath = rootPath;
	}

	@Override
	public String save(InputStream inputStream, String name) {
		try (OutputStream outputStream = new FileOutputStream(rootPath + File.separator + name)) {
			inputStream.transferTo(outputStream);
			return name;
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public InputStream load(String name) {
		try {
			return new FileInputStream(rootPath + File.separator + name);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
