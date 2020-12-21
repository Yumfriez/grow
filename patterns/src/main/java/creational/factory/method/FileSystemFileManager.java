package creational.factory.method;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class FileSystemFileManager extends AbstractFileManager {
	@Override
	public FileLoader getFileLoader() {
		return new FileSystemFileLoader();
	}
}
