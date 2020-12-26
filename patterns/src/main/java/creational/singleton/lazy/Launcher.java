package creational.singleton.lazy;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Launcher {
	public static void main(String[] args) {
		doubleCheckedLockingSingleton();
		onDemandHolderSingleton();
		synchronizedMethodSingleton();
	}

	private static void doubleCheckedLockingSingleton() {
		DoubleCheckedLockingSingleton.getInstance().setName("DoubleCheckedLockingSingleton");
		System.out.println(DoubleCheckedLockingSingleton.getInstance().getName());
		DoubleCheckedLockingSingleton.getInstance().printHello();
	}

	private static void onDemandHolderSingleton() {
		OnDemandHolderSingleton.getInstance().setName("OnDemandHolderSingleton");
		System.out.println(OnDemandHolderSingleton.getInstance().getName());
		OnDemandHolderSingleton.getInstance().printHello();
	}

	private static void synchronizedMethodSingleton() {
		SynchronizedMethodSingleton.getInstance().setName("SynchronizedMethodSingleton");
		System.out.println(SynchronizedMethodSingleton.getInstance().getName());
		SynchronizedMethodSingleton.getInstance().printHello();
	}
}
