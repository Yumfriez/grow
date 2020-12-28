package structural.adapter;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class SecuredHttpService {

	public void transferTraffic(HttpsTraffic traffic) {
		System.out.println("Transferring secured http traffic...");
		traffic.transfer();
	}
}
