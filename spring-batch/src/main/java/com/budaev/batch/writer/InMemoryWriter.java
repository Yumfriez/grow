package com.budaev.batch.writer;

import com.budaev.batch.entity.user.User;
import org.springframework.batch.item.support.AbstractItemStreamItemWriter;

import java.util.List;
import java.util.Map;

import static java.util.Optional.ofNullable;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class InMemoryWriter extends AbstractItemStreamItemWriter<User> {

	private final Map<Long, User> userMapping;

	public InMemoryWriter(Map<Long, User> userMapping) {
		this.userMapping = userMapping;
	}

	@Override
	public void write(List<? extends User> users) {
		users.forEach(u -> ofNullable(userMapping.get(u.getId())).ifPresentOrElse(user -> {
			user.setLogin(u.getLogin());
			user.setPassword(u.getPassword());
		}, () -> userMapping.put(u.getId(), u)));
	}
}
