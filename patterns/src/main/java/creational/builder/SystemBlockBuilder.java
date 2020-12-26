package creational.builder;

import creational.builder.entity.*;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class SystemBlockBuilder {

	private final SystemBlock systemBlock;

	public SystemBlockBuilder() {
		this.systemBlock = new SystemBlock();
	}

	public SystemBlockBuilder(SystemBlock systemBlock) {
		this.systemBlock = systemBlock;
	}

	public SystemBlockBuilder withCarcase(Carcase carcase) {
		systemBlock.setCarcase(carcase);
		return this;
	}

	public SystemBlockBuilder withMotherboard(Motherboard motherboard) {
		systemBlock.setMotherboard(motherboard);
		return this;
	}

	public SystemBlockBuilder withGraphicCard(GraphicCard graphicCard) {
		systemBlock.setGraphicCard(graphicCard);
		return this;
	}

	public SystemBlockBuilder withProcessor(Processor processor) {
		systemBlock.setProcessor(processor);
		return this;
	}

	public SystemBlockBuilder withHardDisk(HardDisk hardDisk) {
		systemBlock.setHardDisk(hardDisk);
		return this;
	}

	public SystemBlock get() {
		return systemBlock;
	}
}
