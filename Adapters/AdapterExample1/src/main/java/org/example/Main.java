package org.example;

public class Main {
    public static void main(String[] args) {
        Square square = new Square();
        square.size = 15;
        CalculatorAdapter calcAdapter = new CalculatorAdapter();

        int area = calcAdapter.getArea(square);
        System.out.println("Area of square using adapter:"+area);
    }
}