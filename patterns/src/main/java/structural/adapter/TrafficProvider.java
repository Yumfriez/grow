package structural.adapter;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class TrafficProvider {

	public HttpTraffic getTraffic() {
		return new HttpTraffic();
	}
}
