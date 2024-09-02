package com.example.gracefulshutdowndemo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class ShutdownTestController {
    private static final Logger logger = LoggerFactory.getLogger(ShutdownTestController.class);

    @GetMapping("/shutdown-test")
    public String shutdownTest() {
        try {
            // 긴 처리 시간을 시뮬레이션하기 위해 10초간 대기
            logger.info("Received request at /shutdown-test, starting 10 second delay...");
            Thread.sleep(10000); // 10초 (10,000밀리초)
            logger.info("Request completed at /shutdown-test after delay.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Thread was interrupted during sleep!", e);
            return "Thread was interrupted!";
        }
        return "Request completed successfully after a delay!";
    }
}
