package creational.method;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Launcher {
	public static void main(String[] args) {

		FileManager urlFileManage = new UrlFileManager();
		urlFileManage.copyFile("https://avatars2.githubusercontent.com/u/31598109?s=460&amp;u=719e3ed177f8dc5e8a005cd75dd911ce3dba3741&amp;v=4", "./file.jpg");

		FileManager fileSystemFileManager = new FileSystemFileManager();
		fileSystemFileManager.copyFile("./file.jpg", "./patterns/file.jpg");
	}
}
