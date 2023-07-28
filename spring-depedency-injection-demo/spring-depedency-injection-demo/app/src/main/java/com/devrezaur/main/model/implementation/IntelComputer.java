package com.devrezaur.main.model.implementation;

import com.devrezaur.main.model.Computer;

public class IntelComputer implements Computer {

    private String brand;
    private String processor;
    private String ram;
    private String hdd;

    // No arg constructor
    public IntelComputer() {
        System.out.println("No arg constructor called - IntelComputer class");
    }

    // All arg constructor
    public IntelComputer(String brand, String processor, String ram, String hdd) {
        this.brand = brand;
        this.processor = processor;
        this.ram = ram;
        this.hdd = hdd;
        System.out.println("All arg constructor called - IntelComputer class");
    }

    // Method to print computer configuration
    @Override
    public void printConfiguration() {
        System.out.println("Brand: " + this.brand);
        System.out.println("Processor: " + this.processor);
        System.out.println("RAM: " + this.ram);
        System.out.println("HDD: " + this.hdd);
    }

    //////////////////////////// Getters & setters methods /////////////////////////////////////
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }
}
