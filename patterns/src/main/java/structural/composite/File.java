package structural.composite;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class File implements FileSystemComponent {

	private int size;
	private String name;
	private Path path;

	public File(int size, String name, Path parentPath) {
		this.size = size;
		this.name = name;
		this.path = Paths.get(parentPath.toString(), name);
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Path getPath() {
		return path;
	}
}
