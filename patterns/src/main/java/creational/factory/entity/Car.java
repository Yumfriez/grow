package creational.factory.entity;

import creational.factory.entity.exception.OverweightException;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Car {

	private Carcase carcase;
	private Engine engine;
	private List<Wheel> wheels;
	private final ExecutorService wheelExecutorService;

	public Car(Carcase carcase, Engine engine, List<Wheel> wheels) throws OverweightException {
		validateWeight(carcase, engine, wheels);
		this.carcase = carcase;
		this.engine = engine;
		this.wheels = wheels;
		this.wheelExecutorService = Executors.newFixedThreadPool(this.wheels.size());
	}

	private void validateWeight(Carcase carcase, Engine engine, List<Wheel> wheels) throws OverweightException {
		if (carcase.getLiftLimit() < engine.getWeight() + wheels.stream().mapToInt(Weighed::getWeight).sum()) {
			throw new OverweightException("Components weight is greater than carcase can afford.");
		}
	}

	public Carcase getCarcase() {
		return carcase;
	}

	public void setCarcase(Carcase carcase) {
		this.carcase = carcase;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public List<Wheel> getWheels() {
		return wheels;
	}

	public void setWheels(List<Wheel> wheels) {
		this.wheels = wheels;
	}

	public void ride() {
		engine.run();
		wheels.forEach(wheel -> wheelExecutorService.submit(wheel::spin));
	}

	public void stop() {
		wheelExecutorService.shutdown();
	}
}
