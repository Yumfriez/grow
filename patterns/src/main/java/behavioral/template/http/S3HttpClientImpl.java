package behavioral.template.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

import static java.util.Optional.ofNullable;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class S3HttpClientImpl implements S3HttpClient {

	private final Map<String, Set<String>> buckets;

	public S3HttpClientImpl(Map<String, Set<String>> buckets) {
		this.buckets = buckets;
	}

	@Override
	public void save(String bucket, String fileName, InputStream inputStream) throws IOException {
		ofNullable(buckets.get(bucket)).ifPresent(files -> {
			System.out.println("Saving file " + fileName + " to the bucket " + bucket);
			files.add(fileName);
		});
	}
}
