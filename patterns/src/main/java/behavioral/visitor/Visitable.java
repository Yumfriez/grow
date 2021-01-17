package behavioral.visitor;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public interface Visitable {

	void accept(FilterVisitor filterVisitor);
}
