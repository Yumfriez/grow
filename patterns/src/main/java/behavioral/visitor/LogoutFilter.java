package behavioral.visitor;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class LogoutFilter implements Filter {
	@Override
	public void doFilter(String request, String response) {
		System.out.println("Log out");
	}
}
