package com.sandeep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootStarter {

    @GetMapping
    public String messg(){
        return "Hurray...! your application is loaded fine using Jenkins CI/CD pipeline";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarter.class, args);
    }

}
