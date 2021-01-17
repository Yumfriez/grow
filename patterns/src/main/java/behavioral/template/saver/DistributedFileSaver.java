package behavioral.template.saver;

import behavioral.template.http.S3HttpClient;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import static java.util.Optional.ofNullable;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class DistributedFileSaver extends AbstractFileSaver {

	private final S3HttpClient s3HttpClient;
	private final Map<String, String> bucketNameMapping;

	public DistributedFileSaver(S3HttpClient s3HttpClient, Map<String, String> bucketNameMapping) {
		this.s3HttpClient = s3HttpClient;
		this.bucketNameMapping = bucketNameMapping;
	}

	@Override
	void save(String fileName, InputStream inputStream) throws IOException {
		final String bucketName = resolveBucketName(fileName);
		s3HttpClient.save(bucketName, fileName, inputStream);
	}

	private String resolveBucketName(String fileName) throws IOException {
		final String extension = resolveExtension(fileName);
		return ofNullable(bucketNameMapping.get(extension)).orElseThrow(() -> new IOException(
				"Unsupported file extension: " + extension));
	}

	private String resolveExtension(String fileName) {
		return FilenameUtils.getExtension(fileName);
	}
}
