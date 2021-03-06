package behavioral.command.impl;

import behavioral.command.entity.Cart;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class CleanCommand implements CartLifecycleCommand {
	@Override
	public void invoke(Cart cart) {
		cart.getItems().clear();
		System.out.println("All items removed from cart");
	}
}
