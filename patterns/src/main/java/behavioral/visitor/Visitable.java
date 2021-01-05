package behavioral.visitor;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public interface Visitable {

	void accept(FilterVisitor filterVisitor);
}