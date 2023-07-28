package com.devrezaur.main.model.implementation;

import com.devrezaur.main.model.Computer;

public class AmdComputer implements Computer {

    // Attributes
    private String brand;
    private String processor;
    private String gpu;

    // No arg constructor
    public AmdComputer() {
        System.out.println("No arg constructor called - AmdComputer class");
    }

    // All arg constructor
    public AmdComputer(String brand, String processor, String gpu) {
        this.brand = brand;
        this.processor = processor;
        this.gpu = gpu;
        System.out.println("All arg constructor called - AmdComputer class");
    }

    // Method to print computer configuration
    @Override
    public void printConfiguration() {
        System.out.println("Brand: " + this.brand);
        System.out.println("Processor: " + this.processor);
        System.out.println("GPU: " + this.gpu);
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

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }
}
