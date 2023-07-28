package com.kazi.controllers;

import org.springframework.stereotype.Component;

public class Engine {
    public String name;
    public String price;

    public Engine(String name, String price){
        this.name = name;
        this.price = price;
    }
    public void printEngine(){
        System.out.println("Engine name is: "+this.name);
    }
}
