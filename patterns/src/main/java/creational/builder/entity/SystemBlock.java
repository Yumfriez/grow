package creational.builder.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class SystemBlock implements Serializable {

	private Carcase carcase;
	private Motherboard motherboard;
	private GraphicCard graphicCard;
	private Processor processor;
	private HardDisk hardDisk;

	public SystemBlock() {
	}

	public Carcase getCarcase() {
		return carcase;
	}

	public void setCarcase(Carcase carcase) {
		this.carcase = carcase;
	}

	public Motherboard getMotherboard() {
		return motherboard;
	}

	public void setMotherboard(Motherboard motherboard) {
		this.motherboard = motherboard;
	}

	public GraphicCard getGraphicCard() {
		return graphicCard;
	}

	public void setGraphicCard(GraphicCard graphicCard) {
		this.graphicCard = graphicCard;
	}

	public Processor getProcessor() {
		return processor;
	}

	public void setProcessor(Processor processor) {
		this.processor = processor;
	}

	public HardDisk getHardDisk() {
		return hardDisk;
	}

	public void setHardDisk(HardDisk hardDisk) {
		this.hardDisk = hardDisk;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SystemBlock that = (SystemBlock) o;
		return Objects.equals(carcase, that.carcase) && Objects.equals(motherboard, that.motherboard) && Objects.equals(graphicCard,
				that.graphicCard
		) && Objects.equals(processor, that.processor) && Objects.equals(hardDisk, that.hardDisk);
	}

	@Override
	public int hashCode() {
		return Objects.hash(carcase, motherboard, graphicCard, processor, hardDisk);
	}
}
