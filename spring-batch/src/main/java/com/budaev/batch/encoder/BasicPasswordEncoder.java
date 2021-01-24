package com.budaev.batch.encoder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class BasicPasswordEncoder implements PasswordEncoder {

	@Override
	public String encrypt(String raw) {
		return Base64.getEncoder().encodeToString(raw.getBytes(StandardCharsets.UTF_8));
	}
}
