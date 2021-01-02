package behavioral.memento;

import java.util.Set;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Database {

	private Set<Table> tables;

	public Database() {
	}

	public Database(Set<Table> tables) {
		this.tables = tables;
	}

	public Set<Table> getTables() {
		return tables;
	}

	public void setTables(Set<Table> tables) {
		this.tables = tables;
	}
}
