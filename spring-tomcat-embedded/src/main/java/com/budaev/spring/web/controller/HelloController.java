package com.budaev.spring.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

	@GetMapping
	public String hello() {
		return "hello";
	}
}
