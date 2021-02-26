package com.budaev.orm.controller;

import com.budaev.orm.entity.domain.User;
import com.budaev.orm.jpa.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

	private final UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping
	public User createUser() {
		final User user = new User();
		user.setLogin("login");
		user.setPassword("rawPassword");
		user.setEmail("email@gmail.com");

		return userRepository.save(user);

	}
}
