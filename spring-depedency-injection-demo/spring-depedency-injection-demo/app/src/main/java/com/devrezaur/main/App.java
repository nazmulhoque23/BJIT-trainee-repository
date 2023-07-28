package com.devrezaur.main;

import com.devrezaur.main.model.Developer;
import com.devrezaur.main.model.config.BeanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        Developer developer1 = context.getBean(Developer.class);
        developer1.getDetails();
    }
}
