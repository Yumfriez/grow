package structural.proxy;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static void main(String[] args) throws IOException, URISyntaxException {
		final File file = new File(Launcher.class.getResource("/file.jpg").toURI());

		final HeavyImage heavyImage = new HeavyImage(file);
		final byte[] bytes = heavyImage.asBytes();
		System.out.println(bytes.length);

		final long beforeInit = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
		System.out.println("BEFORE INIT: " + beforeInit + "KB");

		final List<HeavyImage> heavyImages = IntStream.range(0, 500).mapToObj(i -> {
			try {
				return new HeavyImage(file);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}).collect(Collectors.toList());

		final long afterInit = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
		System.out.println("AFTER INIT: " + afterInit + "KB");

		System.out.println("DELTA: " + (afterInit - beforeInit) + "KB");

		final long beforeProxyInit = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
		System.out.println("BEFORE PROXY INIT: " + beforeProxyInit + "KB");

		final List<ImageProxy> proxyImages = IntStream.range(0, 200).mapToObj(i -> {
			try {
				return new ImageProxy(file);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}).collect(Collectors.toList());

		final long afterProxyInit = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
		System.out.println("AFTER PROXY INIT: " + afterProxyInit + "KB");

		System.out.println("DELTA: " + (afterProxyInit - beforeProxyInit) + "KB");

		heavyImages.forEach(System.out::print);
		System.out.println();
		proxyImages.forEach(System.out::print);

	}
}
