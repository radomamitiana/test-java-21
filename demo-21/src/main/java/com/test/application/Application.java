package com.test.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        new Application().run(args);
    }

    private void run(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
