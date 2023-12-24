package com.programmingplanet.lld.designpatterns.creational.Factory.Pizza;

public class CheesePizza extends Pizza{
    public CheesePizza() {
        this.name = "Cheese Pizza";
        this.size = 12;
    }

    @Override
    public void addToppings() {
        System.out.println("Adding cheese toppings");
    }

    @Override
    public void bake() {
        System.out.println("Baking the pizza at 400 degrees for 20 minutes");
    }
}
