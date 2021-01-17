package com.budaev.spring.core.cache.boot;

import com.budaev.spring.core.cache.common.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@Service
public class DummyManipulator {

	private final DummyService dummyService;

	@Autowired
	public DummyManipulator(DummyService dummyService) {
		this.dummyService = dummyService;
	}

	@PostConstruct
	public void manipulateService() {
		final String key = "key";
		System.out.println(dummyService.getDummy(key));
		System.out.println(dummyService.getDummy(key));

		dummyService.addDummy(key, "I'm dummy");
		System.out.println(dummyService.getDummy(key));

		dummyService.removeDummy(key);
		System.out.println(dummyService.getDummy(key));
	}
}
