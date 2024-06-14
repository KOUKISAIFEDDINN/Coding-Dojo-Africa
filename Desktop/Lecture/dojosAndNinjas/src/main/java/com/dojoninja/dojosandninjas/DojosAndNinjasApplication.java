package com.dojoninja.dojosandninjas;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class DojosAndNinjasApplication {
    public static void main(String[] args) {
        SpringApplication.run(DojosAndNinjasApplication.class, args);
    }
}
