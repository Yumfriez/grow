package behavioral.memento;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public interface Transaction {
	void commit();
	void rollback();
}
