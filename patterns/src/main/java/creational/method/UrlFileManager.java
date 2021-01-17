package creational.method;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class UrlFileManager extends AbstractFileManager {
	@Override
	public FileLoader getFileLoader() {
		return new UrlFileLoader();
	}
}
