package behavioral.memento;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Optional.ofNullable;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class TransactionImpl implements Transaction {

	private final Database database;
	private Map<Table, List<Record<?>>> updatedRecordsMapping = new LinkedHashMap<>();
	private Map<Table, List<Record<?>>> previousValuesMapping = new LinkedHashMap<>();

	public TransactionImpl(Database database) {
		this.database = database;
	}

	@Override
	public void commit() {
		updatedRecordsMapping.forEach((t, records) -> database.getTables()
				.stream()
				.filter(table -> table.getName().equals(t.getName()))
				.findFirst()
				.ifPresent(table -> {
					final List<Record<?>> previousRecords = previousValuesMapping.computeIfAbsent(table, pt -> new ArrayList<>());
					records.forEach(record -> table.updateRecord(record).ifPresent(previousRecords::add));
				}));
	}

	@Override
	public void rollback() {
		previousValuesMapping.forEach((t, records) -> database.getTables()
				.stream()
				.filter(table -> table.getName().equals(t.getName()))
				.findFirst()
				.ifPresent(table -> records.forEach(table::updateRecord)));
	}

	public void updateRecord(Table table, Record<?> record) {
		ofNullable(updatedRecordsMapping.get(table)).ifPresentOrElse(records -> records.add(record), () -> {
			final ArrayList<Record<?>> records = new ArrayList<>();
			records.add(record);
			updatedRecordsMapping.put(table, records);
		});
	}
}
