package behavioral.memento;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public interface Transaction {
	void commit();
	void rollback();
}
