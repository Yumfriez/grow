package behavioral.command.impl;

import java.util.Map;
import java.util.Optional;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class CartLifecycleCommandManager {

	private final Map<CartLifecycleCommandType, CartLifecycleCommand> commandMapping;

	public CartLifecycleCommandManager(Map<CartLifecycleCommandType, CartLifecycleCommand> commandMapping) {
		this.commandMapping = commandMapping;
	}

	public Optional<CartLifecycleCommand> getCommand(CartLifecycleCommandType commandType) {
		return Optional.ofNullable(commandMapping.get(commandType));
	}
}
