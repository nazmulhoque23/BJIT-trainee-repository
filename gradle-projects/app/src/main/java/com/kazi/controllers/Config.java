package com.kazi.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Engine engine1(){
        return new Engine("m8Engine", "3000$");
    }

    @Bean
    public Car car1(Engine engine){
        return new Car("Lamborgini", engine);
    }

}
