package behavioral.visitor;

import java.util.List;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class CompositeFilter implements Filter, Visitable {

	private final List<Filter> filters;

	public CompositeFilter(List<Filter> filters) {
		this.filters = filters;
	}

	@Override
	public void doFilter(String request, String response) {
		System.out.println("Invoke filter chain");
		filters.forEach(f -> f.doFilter(request, response));
	}

	@Override
	public void accept(FilterVisitor filterVisitor) {
		filterVisitor.visit(this);
	}

	public List<Filter> getFilters() {
		return filters;
	}
}
