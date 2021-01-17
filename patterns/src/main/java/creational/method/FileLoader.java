package creational.method;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public interface FileLoader {

	InputStream load(String path) throws IOException;

}
