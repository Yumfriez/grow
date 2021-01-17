package structural.adapter;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class SecuredHttpService {

	public void transferTraffic(HttpsTraffic traffic) {
		System.out.println("Transferring secured http traffic...");
		traffic.transfer();
	}
}
