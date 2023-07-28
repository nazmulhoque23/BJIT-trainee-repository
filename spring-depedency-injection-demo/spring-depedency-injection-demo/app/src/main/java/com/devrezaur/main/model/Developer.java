package com.devrezaur.main.model;

public class Developer {

    // Attributes
    private String developerName;
    private String techStack;
    private Computer computer;

    // No arg constructor
    public Developer() {
        System.out.println("No arg constructor called - Developer class");
    }

    // All arg constructor
    public Developer(String developerName, String techStack, Computer computer) {
        this.developerName = developerName;
        this.techStack = techStack;
        this.computer = computer;
        System.out.println("All arg constructor called - Developer class");
    }

    // Method to print developer object details
    public void getDetails() {
        System.out.println("Developer Name= " + this.developerName);
        System.out.println("Tech Stack= " + this.techStack);
        computer.printConfiguration();
    }

    //////////////////////////// Getters & setters methods /////////////////////////////////////
    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
