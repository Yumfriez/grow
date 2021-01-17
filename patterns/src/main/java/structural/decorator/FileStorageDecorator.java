package structural.decorator;

import java.io.InputStream;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class FileStorageDecorator implements FileStorage {

	private final FileStorage fileStorage;

	public FileStorageDecorator(FileStorage fileStorage) {
		this.fileStorage = fileStorage;
	}

	@Override
	public String save(InputStream inputStream, String name) {
		return fileStorage.save(inputStream, name);
	}

	@Override
	public InputStream load(String name) {
		return fileStorage.load(name);
	}
}
