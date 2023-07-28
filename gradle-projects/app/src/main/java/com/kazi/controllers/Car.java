package com.kazi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Car {
    public String name;
    @Autowired
    public Engine engine;

    public Car(String name, Engine engine){
        this.name = name;
        this.engine = engine;
    }

    public void getCar(){
        System.out.println("Car name is : "+ this.name);
        engine.printEngine();
    }
}
