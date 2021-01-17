package structural.decorator;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class EncryptedContentDecorator extends FileStorageDecorator {
	public EncryptedContentDecorator(FileStorage fileStorage) {
		super(fileStorage);
	}

	@Override
	public String save(InputStream inputStream, String name) {
		try {
			final byte[] bytes = inputStream.readAllBytes();
			final byte[] encoded = Base64.getEncoder().encode(bytes);
			return super.save(new ByteArrayInputStream(encoded), name);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	@Override
	public InputStream load(String name) {
		try (final InputStream inputStream = super.load(name)) {
			final byte[] bytes = inputStream.readAllBytes();
			final byte[] decoded = Base64.getDecoder().decode(bytes);
			return new ByteArrayInputStream(decoded);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
