package creational.builder;

import creational.builder.entity.*;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static void main(String[] args) {
		final SystemBlock systemBlock = new SystemBlockBuilder().withCarcase(new Carcase()).withHardDisk(new HardDisk()).get();

		final SystemBlock fullSystemBlock = new SystemBlockBuilder().withCarcase(new Carcase())
				.withMotherboard(new Motherboard())
				.withProcessor(new Processor())
				.withHardDisk(new HardDisk())
				.withGraphicCard(new GraphicCard())
				.get();
	}
}
