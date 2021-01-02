package behavioral.command;

import behavioral.command.entity.Cart;
import behavioral.command.entity.Item;
import behavioral.command.impl.*;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class Launcher {

	public static void main(String[] args) {
		final Map<CartLifecycleCommandType, CartLifecycleCommand> commandMapping = Map.ofEntries(Map.entry(CartLifecycleCommandType.CLEAN,
				new CleanCommand()
				),
				Map.entry(CartLifecycleCommandType.SAVE_HISTORY, new SaveHistoryCommand()),
				Map.entry(CartLifecycleCommandType.MAKE_ORDER, new MakeOrderCommand())
		);

		final CartLifecycleCommandManager commandManager = new CartLifecycleCommandManager(commandMapping);

		Cart cart = new Cart();
		cart.setItems(new ArrayList<>(List.of(new Item(), new Item())));
		commandManager.getCommand(CartLifecycleCommandType.MAKE_ORDER).ifPresent(c -> c.invoke(cart));
		commandManager.getCommand(CartLifecycleCommandType.SAVE_HISTORY).ifPresent(c -> c.invoke(cart));
		commandManager.getCommand(CartLifecycleCommandType.CLEAN).ifPresent(c -> c.invoke(cart));

		Assertions.assertTrue(cart.getItems().isEmpty());
	}
}
