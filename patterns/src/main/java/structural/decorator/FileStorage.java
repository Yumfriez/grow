package structural.decorator;

import java.io.InputStream;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public interface FileStorage {

	String save(InputStream inputStream, String name);

	InputStream load(String name);

}
