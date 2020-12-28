package structural.bridge;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class AdvancedAppManager extends AppManager {

	public Map<String, List<String>> getAppStates() {
		return getApps().stream().collect(groupingBy(App::getName, mapping(App::getState, Collectors.toList())));
	}

	public void stopAllApps(boolean unload) {
		getApps().forEach(App::stop);
		if (unload) {
			getApps().clear();
		}
	}
}
