package com.example.gracefulshutdowndemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import jakarta.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class GracefulShutdownDemoApplication {
	private static final Logger logger = LoggerFactory.getLogger(GracefulShutdownDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GracefulShutdownDemoApplication.class, args);
	}

	@PreDestroy
	public void onExit() {
		logger.info("### Application is shutting down. Graceful shutdown initiated. ###");
	}

}
