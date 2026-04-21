package com.kusen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.kusen.repository")
public class KusenShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(KusenShopApplication.class, args);
    }
}
