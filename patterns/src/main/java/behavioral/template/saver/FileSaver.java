package behavioral.template.saver;

import java.io.File;
import java.io.IOException;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public interface FileSaver {

	void save(File file) throws IOException;
}
