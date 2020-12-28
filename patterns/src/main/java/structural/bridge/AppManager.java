package structural.bridge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class AppManager {

	private final List<App> apps;

	public AppManager() {
		this.apps = new ArrayList<>();
	}

	public List<App> getApps() {
		return apps;
	}

	public void runApp(App app) {
		app.start();
		apps.add(app);
	}

	public void stopApp(String name, boolean unload) {
		final Iterator<App> iterator = apps.iterator();
		while (iterator.hasNext()) {
			final App app = iterator.next();
			if (app.getName().equals(name)) {
				app.stop();
				if (unload) {
					iterator.remove();
				}
			}
		}
	}
}
