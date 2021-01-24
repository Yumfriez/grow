package com.budaev.batch.encoder;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public interface PasswordEncoder {

	String encrypt(String raw);
}
