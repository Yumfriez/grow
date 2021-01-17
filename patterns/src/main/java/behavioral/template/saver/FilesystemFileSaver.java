package behavioral.template.saver;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class FilesystemFileSaver extends AbstractFileSaver {

	private final Path rootPath;

	public FilesystemFileSaver(Path rootPath) {
		this.rootPath = rootPath;
	}

	@Override
	void save(String fileName, InputStream inputStream) throws IOException {
		Files.copy(inputStream, Paths.get(rootPath.toString(), fileName));
	}
}
