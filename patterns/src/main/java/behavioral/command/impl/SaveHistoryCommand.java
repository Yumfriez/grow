package behavioral.command.impl;

import behavioral.command.entity.Cart;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class SaveHistoryCommand implements CartLifecycleCommand {
	@Override
	public void invoke(Cart cart) {
		System.out.println("Cart saved as history");
	}
}
