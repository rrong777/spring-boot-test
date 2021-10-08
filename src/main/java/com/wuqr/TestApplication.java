package com.wuqr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/hello")
public class TestApplication {

    @GetMapping
    public String hello() {
        return "hello world!";
    }
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
