package structural.bridge;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static final String GTA_5_NAME = "GTA V";
	public static final String FALLOUT_APP_NAME = "Fallout: New Vegas";
	public static final String OPERA_NAME = "Opera";

	public static void main(String[] args) {
		AppManager appManager = new AppManager();

		final Game gta = new Game(GTA_5_NAME);
		final Game fallout = new Game("Fallout: New Vegas");
		final Browser opera = new Browser(OPERA_NAME);

		appManager.runApp(gta);
		appManager.runApp(fallout);
		appManager.runApp(opera);

		appManager.stopApp(GTA_5_NAME, true);
		appManager.stopApp(FALLOUT_APP_NAME, true);
		appManager.stopApp(OPERA_NAME, true);

		AdvancedAppManager advancedAppManager = new AdvancedAppManager();

		advancedAppManager.runApp(gta);
		advancedAppManager.runApp(fallout);
		advancedAppManager.runApp(opera);

		System.out.println(advancedAppManager.getAppStates());

		advancedAppManager.stopAllApps(false);

		System.out.println(advancedAppManager.getAppStates());
	}
}
