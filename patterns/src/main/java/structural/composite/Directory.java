package structural.composite;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Directory implements FileSystemComponent {

	private String name;
	private Path path;
	private List<FileSystemComponent> components;

	public Directory(String name, Path parentPath) {
		this.name = name;
		this.path = Paths.get(parentPath.toString(), name);
		this.components = new ArrayList<>();
	}

	@Override
	public int getSize() {
		return components.stream().mapToInt(FileSystemComponent::getSize).sum();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Path getPath() {
		return path;
	}

	public void addComponent(FileSystemComponent component) {
		components.add(component);
	}

	public void removeComponent(String name) {
		components.removeIf(c -> c.getName().equals(name));
	}
}
