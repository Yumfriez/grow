package structural.composite;

import java.nio.file.Path;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public interface FileSystemComponent {
	int getSize();
	String getName();
	Path getPath();
}
