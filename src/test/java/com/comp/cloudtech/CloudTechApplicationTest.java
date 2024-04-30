package com.comp.cloudtech;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.comp.cloudtech.controller.HelloWorldController;

@SpringBootTest
class CloudTechApplicationTest {

	@Autowired
	private HelloWorldController helloWorldController;

	@Test
	void contextLoads() {
		// to ensure that controller is getting created inside the application context
		assertNotNull(helloWorldController);
	}

}
