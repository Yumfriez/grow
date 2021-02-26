package com.budaev.orm.controller;

import com.budaev.orm.entity.domain.Item;
import com.budaev.orm.entity.domain.Order;
import com.budaev.orm.entity.domain.User;
import com.budaev.orm.jpa.repository.item.ItemRepository;
import com.budaev.orm.jpa.repository.order.OrderRepository;
import com.budaev.orm.jpa.repository.user.UserRepository;
import com.budaev.orm.entity.model.MakeOrderRq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

	private final OrderRepository orderRepository;
	private final UserRepository userRepository;
	private final ItemRepository itemRepository;

	@Autowired
	public OrderController(OrderRepository orderRepository, UserRepository userRepository, ItemRepository itemRepository) {
		this.orderRepository = orderRepository;
		this.userRepository = userRepository;
		this.itemRepository = itemRepository;
	}

	@PostMapping
	@Transactional
	public Order makeOrder(@Valid @RequestBody MakeOrderRq makeOrderRq) {
		final List<Item> foundItems = itemRepository.findAllById(makeOrderRq.getItemIds());
		final User user = userRepository.findById(1L).orElseThrow(() -> new RuntimeException("User not found"));

		final Order order = new Order();
		order.setCreationDate(Instant.now());
		order.setUser(user);
		order.setState("CREATED");
		orderRepository.save(order);

		foundItems.forEach(order::addItem);

		return null;

	}
}
