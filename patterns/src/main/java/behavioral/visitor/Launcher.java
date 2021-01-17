package behavioral.visitor;

import java.util.List;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static void main(String[] args) {

		BasicAuthFilter basicAuthFilter = new BasicAuthFilter("basic");
		Filter logoutFilter = new LogoutFilter();
		final CompositeFilter compositeFilter = new CompositeFilter(List.of(basicAuthFilter, logoutFilter));

		FilterVisitor filterVisitor = new FilterMetadataPrinter();

		filterVisitor.visit(basicAuthFilter);
		filterVisitor.visit(compositeFilter);

	}
}
