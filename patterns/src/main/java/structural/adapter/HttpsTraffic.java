package structural.adapter;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class HttpsTraffic {

	private SSLCertificate certificate;

	public HttpsTraffic(SSLCertificate certificate) {
		this.certificate = certificate;
	}

	public SSLCertificate getCertificate() {
		return certificate;
	}

	public void setCertificate(SSLCertificate certificate) {
		this.certificate = certificate;
	}

	public void transfer() {
		System.out.println("Traffic with certificate: " + certificate.getName());
	}
}
