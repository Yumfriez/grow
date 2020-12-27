package structural.composite;

import java.nio.file.Path;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public interface FileSystemComponent {
	int getSize();
	String getName();
	Path getPath();
}
