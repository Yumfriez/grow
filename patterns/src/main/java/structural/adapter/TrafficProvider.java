package structural.adapter;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class TrafficProvider {

	public HttpTraffic getTraffic() {
		return new HttpTraffic();
	}
}
