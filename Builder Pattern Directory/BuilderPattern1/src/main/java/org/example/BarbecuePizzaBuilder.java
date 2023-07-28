package org.example;

public class BarbecuePizzaBuilder extends PizzaBuilder{
    public void buildDough(){
        pizza.setDough("hand made");
    }
    public void buildSauce(){
        pizza.setSauce("b.b.q sauce");
    }
    public void buildTopping(){
        pizza.setToppings("chicken+mushroom");
    }
}
