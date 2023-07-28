package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Generic Box ===");
        Box box = new Box();
        box.size();
        box.functionality();

        System.out.println("-------------------");
        System.out.println("=== Box kind 1 ===");
        Box tiffinBox = new TiffinBox();
        tiffinBox.functionality();
        tiffinBox.size();

        System.out.println("-------------------");
        System.out.println("=== Box kind 2 ===");
        Box container = new ContainerBox();
        container.functionality();
        container.size();

    }
}