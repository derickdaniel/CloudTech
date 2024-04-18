package com.example.helloworld;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.helloworld.controller.HelloWorldController;

@SpringBootTest
class HelloWorldApplicationTests {

	@Autowired
	private HelloWorldController helloWorldController;

	@Test
	void contextLoads() {
		// to ensure that controller is getting created inside the application context
		assertNotNull(helloWorldController);
	}

}
