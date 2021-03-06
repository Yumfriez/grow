package behavioral.command.impl;

import behavioral.command.entity.Cart;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class MakeOrderCommand implements CartLifecycleCommand {
	@Override
	public void invoke(Cart cart) {
		System.out.println("Cart order created");
	}
}
