package structural.proxy;

import org.apache.commons.io.FilenameUtils;

import javax.imageio.stream.ImageInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class ImageProxy implements Image {

	private final File file;
	private Image image;

	public ImageProxy(File file) throws IOException {
		try (final FileInputStream fileInputStream = new FileInputStream(file)) {
			if (ImageExtensionValidator.validate(FilenameUtils.getExtension(file.getName()), fileInputStream)) {
				this.file = file;
			} else {
				throw new IOException("Invalid file extension");
			}
		}
	}

	@Override
	public ImageInputStream asStream() throws IOException {
		if (Objects.isNull(image)) {
			image = new HeavyImage(file);
		}
		return image.asStream();
	}

	@Override
	public byte[] asBytes() {
		if (Objects.isNull(image)) {
			try {
				image = new HeavyImage(file);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return image.asBytes();
	}
}
