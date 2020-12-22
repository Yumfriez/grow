package creational.method;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public interface FileLoader {

	InputStream load(String path) throws IOException;

}
