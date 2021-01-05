package behavioral.template;

import behavioral.template.http.S3HttpClient;
import behavioral.template.http.S3HttpClientImpl;
import behavioral.template.saver.DistributedFileSaver;
import behavioral.template.saver.FileSaver;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static void main(String[] args) throws IOException, URISyntaxException {

		final Map<String, Set<String>> bucketMapping = Map.of("jpgBucket", new HashSet<>(), "txtBucket", new HashSet<>());
		S3HttpClient s3HttpClient = new S3HttpClientImpl(bucketMapping);

		FileSaver fileSaver = new DistributedFileSaver(s3HttpClient, Map.of("jpg", "jpgBucket", "txt", "txtBucket"));


		fileSaver.save(new File(Launcher.class.getResource("/hello.txt").toURI()));
		fileSaver.save(new File(Launcher.class.getResource("/file.jpg").toURI()));

	}
}
