package org.example;

public class CalculatorAdapter {
    public int getArea(Square square){
        Calculator calc = new Calculator();

        Rectangle rectangle = new Rectangle();
        rectangle.width = rectangle.height = square.size;
        int area = calc.getArea(rectangle);
        return area;
    }
}
