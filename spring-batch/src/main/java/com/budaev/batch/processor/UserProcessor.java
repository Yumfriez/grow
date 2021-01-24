package com.budaev.batch.processor;

import com.budaev.batch.encoder.PasswordEncoder;
import com.budaev.batch.entity.user.CsvUser;
import com.budaev.batch.entity.user.User;
import org.springframework.batch.item.ItemProcessor;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class UserProcessor implements ItemProcessor<CsvUser, User> {

	private final static AtomicLong ID_INCREMENTER = new AtomicLong(1L);

	private final PasswordEncoder passwordEncoder;

	public UserProcessor(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public User process(CsvUser csvUser) {
		User user = new User();
		user.setId(ID_INCREMENTER.getAndIncrement());
		user.setLogin(csvUser.getLogin());
		final String encryptedPassword = passwordEncoder.encrypt(csvUser.getPassword());
		user.setPassword(encryptedPassword);
		return user;
	}
}
