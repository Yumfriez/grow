package behavioral.visitor;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public interface FilterVisitor {

	void visit(BasicAuthFilter basicAuthFilter);
	void visit(CompositeFilter compositeFilter);
}
