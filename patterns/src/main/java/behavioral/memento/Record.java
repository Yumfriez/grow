package behavioral.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Record<T> {

	private T id;
	private List<?> values;

	public Record(Record<T> record) {
		this.id = record.getId();
		this.values = new ArrayList<>(record.getValues());
	}

	public Record(T id, List<?> values) {
		this.id = id;
		this.values = values;
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public List<?> getValues() {
		return values;
	}

	public void setValues(List<?> values) {
		this.values = values;
	}

	@Override
	public String toString() {
		return "Record{" + "values=" + values + '}';
	}
}
