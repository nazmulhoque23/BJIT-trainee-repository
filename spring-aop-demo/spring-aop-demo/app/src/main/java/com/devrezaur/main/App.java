package com.devrezaur.main;

import com.devrezaur.main.model.ClassA;
import com.devrezaur.main.model.ClassB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);

        ClassA classA = context.getBean(ClassA.class);
        classA.hello();
        classA.printSomething("Rezaur Rahman");
        System.out.println(classA.sum(10, 20));

//        ClassB classB = context.getBean(ClassB.class);
//        System.out.println(classB.anotherMethod(100));
    }
}
