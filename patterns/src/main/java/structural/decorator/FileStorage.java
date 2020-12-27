package structural.decorator;

import java.io.InputStream;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public interface FileStorage {

	String save(InputStream inputStream, String name);

	InputStream load(String name);

}
