package structural.flyweight;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static void main(String[] args) {
		RodType greenRodType = RodType.of("green", 1000);
		RodType blueRodType = RodType.of("blue", 1000);
		RodType redRodType = RodType.of("red", 1000);

		final long beforePensInit = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
		System.out.println("BEFORE PENS INIT: " + beforePensInit + "KB");

		final List<Pen> greenPens = IntStream.range(0, 100000).mapToObj(i -> new Pen(new Rod(greenRodType))).collect(Collectors.toList());
		final List<Pen> bluePens = IntStream.range(0, 100000).mapToObj(i -> new Pen(new Rod(blueRodType))).collect(Collectors.toList());
		final List<Pen> redPens = IntStream.range(0, 100000).mapToObj(i -> new Pen(new Rod(redRodType))).collect(Collectors.toList());

		final long afterPensInit = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
		System.out.println("AFTER PENS INIT: " + afterPensInit + "KB");

		System.out.println("DELTA: " + (afterPensInit - beforePensInit) + "KB");

		final long beforePensInitNoLightweight = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
		System.out.println("BEFORE PENS INIT (WITHOUT LIGHTWEIGHT): " + beforePensInitNoLightweight + "KB");

		final List<Pen> greenPensNoLightweight = IntStream.range(0, 100000).mapToObj(i -> new Pen(new Rod(RodType.of("green", 1000)))).collect(Collectors.toList());
		final List<Pen> bluePensNoLightweight = IntStream.range(0, 100000).mapToObj(i -> new Pen(new Rod(RodType.of("blue", 1000)))).collect(Collectors.toList());
		final List<Pen> redPensNoLightweight = IntStream.range(0, 100000).mapToObj(i -> new Pen(new Rod(RodType.of("red", 1000)))).collect(Collectors.toList());

		final long afterPensInitNoLightweight = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
		System.out.println("AFTER PENS INIT (WITHOUT LIGHTWEIGHT): " + afterPensInitNoLightweight + "KB");

		System.out.println("DELTA (WITHOUT LIGHTWEIGHT): " + (afterPensInitNoLightweight - beforePensInitNoLightweight) + "KB");

		print(greenPens);
		print(bluePens);
		print(redPens);
		print(greenPensNoLightweight);
		print(bluePensNoLightweight);
		print(redPensNoLightweight);

	}

	private static void print(List<Pen> pens) {
		pens.forEach(Pen::draw);
	}
}
