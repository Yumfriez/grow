package behavioral.template.http;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public interface S3HttpClient {

	void save(String bucket, String fileName, InputStream inputStream) throws IOException;
}
