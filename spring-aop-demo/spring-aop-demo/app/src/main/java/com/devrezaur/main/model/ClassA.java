package com.devrezaur.main.model;

import org.springframework.stereotype.Component;

@Component
public class ClassA {

    public void hello() {
        System.out.println("Hello World");
    }

    public void printSomething(String something) {
        System.out.println(something);
    }

    public int sum(int a, int b) {
        return a + b;
    }
}
