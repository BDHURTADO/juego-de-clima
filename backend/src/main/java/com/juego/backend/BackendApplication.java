package com.juego.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.juego.backend.controller", "com.juego.backend.services", "com.juego.backend.model", "com.juego.backend.config"})
public class BackendApplication {
    public static void main(String[] args) {
        var context = SpringApplication.run(BackendApplication.class, args);
        System.out.println("=== BEANS DE CONTROLADORES ===");
        for (String bean : context.getBeanDefinitionNames()) {
            if (bean.toLowerCase().contains("controller")) {
                System.out.println(bean);
            }
        }
    }
}
