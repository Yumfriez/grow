package behavioral.chain.entity;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Body {

	private Engine engine;

	public static class Engine {

		private final String model;

		public Engine(String model) {
			this.model = model;
		}

		public String getModel() {
			return model;
		}
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
}
