package com.budaev.spring.core.cache.common;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@Service
@CacheConfig(cacheNames = { "dummies" })
public class DummyService {

	private final Map<String, String> slowMap = new HashMap<String, String>() {
		@Override
		public String get(Object key) {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return super.get(key);
		}
	};

	@CachePut(value = "dummies", key = "#key", condition = "#value != null")
	public String addDummy(String key, String value) {
		System.out.println("Add dummy");
		slowMap.put(key, value);
		return value;
	}

	@Cacheable(value = "dummies", key = "#key", unless = "#result == null")
	public String getDummy(String key) {
		System.out.println("Get dummy");
		return slowMap.get(key);
	}

	@CacheEvict(value = "dummies", key = "#key")
	public void removeDummy(String key) {
		System.out.println("Remove dummy");
		slowMap.remove(key);
	}
}
