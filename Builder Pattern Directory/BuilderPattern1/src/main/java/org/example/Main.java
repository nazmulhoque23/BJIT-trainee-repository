package org.example;

public class Main {
    public static void main(String[] args) {

        Waiter waiter = new Waiter();

        PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();
        PizzaBuilder barbecuePizzaBuilder = new BarbecuePizzaBuilder();

        waiter.setPizzaBuilder(hawaiianPizzaBuilder);
        waiter.constructPizza();
        Pizza pizza1 = waiter.getPizza();
        System.out.println(pizza1.toString());

        waiter.setPizzaBuilder(barbecuePizzaBuilder);
        waiter.constructPizza();
        Pizza pizza2 = waiter.getPizza();
        System.out.println(pizza2.toString());
    }
}