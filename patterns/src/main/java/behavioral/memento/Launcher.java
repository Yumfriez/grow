package behavioral.memento;

import java.util.List;
import java.util.Set;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static void main(String[] args) {

		Database database = new Database();
		final Set<Field<FieldType>> userFields = Set.of(new Field<>("login", FieldType.VARCHAR));
		final Table usersTable = new Table("users", userFields);

		final Set<Field<FieldType>> carFields = Set.of(new Field<>("name", FieldType.VARCHAR), new Field<>("mileage", FieldType.INTEGER));
		final Table carTable = new Table("car", carFields);

		database.setTables(Set.of(usersTable, carTable));

		usersTable.addRecord(new Record<>(1L, List.of("firstUser")));
		usersTable.addRecord(new Record<>(2L, List.of("secondUser")));
		carTable.addRecord(new Record<>(3L, List.of("firstCar", 10000)));
		carTable.addRecord(new Record<>(4L, List.of("secondCar", 20000)));

		final TransactionImpl usersTransaction = new TransactionImpl(database);
		usersTransaction.updateRecord(usersTable, new Record<>(2L, List.of("updatedSecondUser")));

		System.out.println(usersTable);
		updateInTransaction(usersTransaction);
		System.out.println(usersTable);

		//instance for exception during commit simulation
		Record<?> updatedSecondCar = new Record<>(4L, List.of("updatedSecondCar", 25000)) {
			@Override
			public Long getId() {
				throw new RuntimeException("Exception during commit: failed to update car");
			}
		};

		final TransactionImpl carTransaction = new TransactionImpl(database);
		carTransaction.updateRecord(carTable, new Record<>(3L, List.of("updatedFirstCar", 15000)));
		carTransaction.updateRecord(carTable, updatedSecondCar);

		System.out.println(carTable);
		updateInTransaction(carTransaction);
		System.out.println(carTable);

		final TransactionImpl carTransactionWithoutException = new TransactionImpl(database);
		carTransactionWithoutException.updateRecord(carTable, new Record<>(3L, List.of("updatedFirstCar", 15000)));
		carTransactionWithoutException.updateRecord(carTable, new Record<>(4L, List.of("updatedSecondCar", 25000)));

		System.out.println(carTable);
		updateInTransaction(carTransactionWithoutException);
		System.out.println(carTable);

	}

	public static void updateInTransaction(Transaction transaction) {
		try {
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace(System.out);
			transaction.rollback();
		}
	}
}
