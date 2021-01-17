package behavioral.memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Table {

	private final String name;
	private final Set<Field<FieldType>> fields;
	private final List<Record<?>> records = new ArrayList<>();

	public Table(String name, Set<Field<FieldType>> fields) {
		this.name = name;
		this.fields = fields;
	}

	public String getName() {
		return name;
	}

	public Set<Field<FieldType>> getFields() {
		return fields;
	}

	public List<Record<?>> getRecords() {
		return records;
	}

	public void addRecord(Record<?> record) {
		records.add(record);
	}

	public Optional<Record<?>> updateRecord(Record<?> record) {
		final Optional<Record<?>> recordOptional = records.stream().filter(r -> r.getId().equals(record.getId())).findFirst();
		if (recordOptional.isPresent()) {
			synchronized (recordOptional.get()) {
				final Record<?> foundRecord = recordOptional.get();
				final Record<?> previousRecord = new Record<>(foundRecord);
				foundRecord.setValues(record.getValues());
				return Optional.of(previousRecord);
			}
		}
		return Optional.empty();
	}

	public void removeRecord(Record<?> record) {
		records.removeIf(r -> r.getId().equals(record.getId()));
	}

	@Override
	public String toString() {
		return "Table{" + "name='" + name + '\'' + ", fields=" + fields + ", records=" + records + '}';
	}
}
