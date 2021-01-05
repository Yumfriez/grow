package behavioral.visitor;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class BasicAuthFilter implements Filter, Visitable {

	private final String name;

	public BasicAuthFilter(String name) {
		this.name = name;
	}

	@Override
	public void doFilter(String request, String response) {
		System.out.println("Get basic auth header...");
	}

	@Override
	public void accept(FilterVisitor filterVisitor) {
		filterVisitor.visit(this);
	}

	public String getName() {
		return name;
	}

}
