package com.example.demo;

import com.example.demo.services.DateTransformer;
import com.example.demo.services.DateTransformerImpl;
import com.example.demo.services.OrderService;
import com.example.demo.services.OrderServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl();
    }

    @Bean
    public DateTransformer dateTransformer() { return new DateTransformerImpl(); }
}
