package behavioral.visitor;

import static java.util.stream.Collectors.joining;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class FilterMetadataPrinter implements FilterVisitor {

	@Override
	public void visit(BasicAuthFilter basicAuthFilter) {
		System.out.println("Filter name: " + basicAuthFilter.getName());
	}

	@Override
	public void visit(CompositeFilter compositeFilter) {
		System.out.println("Filter chain length: " + compositeFilter.getFilters().size());
		System.out.println(
				"Filter chain: " + compositeFilter.getFilters().stream().map(Filter::getClass).map(String::valueOf).collect(joining(", ")));
	}
}
