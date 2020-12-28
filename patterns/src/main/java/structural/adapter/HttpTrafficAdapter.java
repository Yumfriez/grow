package structural.adapter;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class HttpTrafficAdapter extends HttpsTraffic {

	private HttpTraffic httpTraffic;

	public HttpTrafficAdapter(HttpTraffic httpTraffic) {
		super(getDefaultCertificate());
	}

	public HttpTrafficAdapter(HttpTraffic httpTraffic, SSLCertificate sslCertificate) {
		super(sslCertificate);
	}

	public static SSLCertificate getDefaultCertificate() {
		return new SSLCertificate("default");
	}

	@Override
	public void transfer() {
		System.out.println("Http traffic adapter with certificate: " + getCertificate().getName());
	}
}
