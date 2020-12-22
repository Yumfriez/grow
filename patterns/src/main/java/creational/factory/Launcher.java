package creational.factory;

import creational.factory.entity.Car;
import creational.factory.entity.Carcase;
import creational.factory.entity.Engine;
import creational.factory.entity.Wheel;
import creational.factory.entity.exception.OverweightException;
import creational.factory.instance.PartFactory;
import creational.factory.instance.PassengerCarPartFactory;
import creational.factory.instance.TruckPartFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static void main(String[] args) {
		runCar(TruckPartFactory.getInstance());
		runCar(PassengerCarPartFactory.getInstance());
	}

	private static void runCar(PartFactory partFactory) {
		final Carcase carcase = partFactory.createCarcase();
		final Engine engine = partFactory.createEngine();
		final List<Wheel> wheels = IntStream.range(0, 3).mapToObj(i -> partFactory.createWheel()).collect(Collectors.toList());

		try {
			Car car = new Car(carcase, engine, wheels);
			car.ride();
			car.stop();
		} catch (OverweightException e) {
			e.printStackTrace();
		}
	}
}
