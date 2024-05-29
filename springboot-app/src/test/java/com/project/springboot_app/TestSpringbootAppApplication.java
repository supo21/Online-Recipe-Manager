package com.project.springboot_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSpringbootAppApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringbootAppApplication::main).with(TestSpringbootAppApplication.class).run(args);
	}

}
