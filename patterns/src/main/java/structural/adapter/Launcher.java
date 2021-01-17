package structural.adapter;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static void main(String[] args) {
		final TrafficProvider trafficProvider = new TrafficProvider();
		final HttpTraffic traffic = trafficProvider.getTraffic();

		final SecuredHttpService securedHttpService = new SecuredHttpService();
		securedHttpService.transferTraffic(new HttpTrafficAdapter(traffic));
	}

}
