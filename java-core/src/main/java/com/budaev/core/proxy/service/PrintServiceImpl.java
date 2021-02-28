package com.budaev.core.proxy.service;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
public class PrintServiceImpl implements PrintService {
	@Override
	public void print(String line) {
		System.out.println(line);
	}
}
