package behavioral.visitor;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public interface FilterVisitor {

	void visit(BasicAuthFilter basicAuthFilter);
	void visit(CompositeFilter compositeFilter);
}
