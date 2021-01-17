package structural.decorator;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class EncryptedFilenameDecorator extends FileStorageDecorator {
	public EncryptedFilenameDecorator(FileStorage fileStorage) {
		super(fileStorage);
	}

	@Override
	public String save(InputStream inputStream, String name) {
		final String encodedName = Base64.getEncoder().encodeToString(name.getBytes(StandardCharsets.UTF_8));
		super.save(inputStream, encodedName);
		return encodedName;
	}

	@Override
	public InputStream load(String name) {
		return super.load(Base64.getEncoder().encodeToString(name.getBytes(StandardCharsets.UTF_8)));
	}
}
