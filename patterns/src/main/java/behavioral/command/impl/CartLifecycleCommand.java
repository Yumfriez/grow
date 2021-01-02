package behavioral.command.impl;

import behavioral.command.entity.Cart;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public interface CartLifecycleCommand {
	void invoke(Cart cart);
}
