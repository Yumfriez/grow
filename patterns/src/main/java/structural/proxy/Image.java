package structural.proxy;

import javax.imageio.stream.ImageInputStream;
import java.io.IOException;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public interface Image {

	ImageInputStream asStream() throws IOException;
	byte[] asBytes();
}
