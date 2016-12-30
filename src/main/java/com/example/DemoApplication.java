package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.LinkedBlockingDeque;

@SpringBootApplication
public class DemoApplication {

	private static LinkedBlockingDeque<Boolean> run = new LinkedBlockingDeque<Boolean>();

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {

		SpringApplication springApplication = new SpringApplication(DemoApplication.class);

		springApplication.run(args);

		while (run.take()) {
		}
	}

	/**
	 * Stop.
	 */
	static void stop() {
		run.add(false);
	}

}
