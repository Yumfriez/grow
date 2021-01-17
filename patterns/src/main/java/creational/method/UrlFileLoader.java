package creational.method;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class UrlFileLoader implements FileLoader {
	@Override
	public InputStream load(String path) throws IOException {
		return new URL(path).openStream();
	}
}
