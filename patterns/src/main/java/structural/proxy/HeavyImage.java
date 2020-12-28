package structural.proxy;

import org.apache.commons.io.FilenameUtils;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class HeavyImage implements Image {

	private final byte[] bytes;

	public HeavyImage(File file) throws IOException {
		try (final FileInputStream fileInputStream = new FileInputStream(file)) {
			if (ImageExtensionValidator.validate(FilenameUtils.getExtension(file.getName()), fileInputStream)) {
				this.bytes = fileInputStream.readAllBytes();
			} else {
				throw new IOException("Invalid file extension");
			}
		}
	}

	@Override
	public ImageInputStream asStream() throws IOException {
		return ImageIO.createImageInputStream(new ByteArrayInputStream(bytes));
	}

	@Override
	public byte[] asBytes() {
		return bytes;
	}
}
