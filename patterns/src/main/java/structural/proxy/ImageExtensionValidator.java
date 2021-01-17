package structural.proxy;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class ImageExtensionValidator {

	public static boolean validate(String extension, InputStream inputStream) {
		for (Iterator<ImageReader> iterator = ImageIO.getImageReadersBySuffix(extension); iterator.hasNext(); ) {
			ImageReader reader = iterator.next();
			try (ImageInputStream stream = ImageIO.createImageInputStream(inputStream)) {
				reader.setInput(stream);
				return true;
			} catch (IOException e) {
				//Try next ImageReader
			} finally {
				reader.dispose();
			}
		}
		return false;
	}
}
