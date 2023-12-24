package com.programmingplanet.lld.designpatterns.creational.Factory.Pizza;

public class PepperoniPizza extends Pizza{
    public PepperoniPizza() {
        this.name = "Pepperoni Pizza";
        this.size = 12;
    }

    @Override
    public void addToppings() {
        System.out.println("Adding pepperoni toppings");
    }

    @Override
    public void bake() {
        System.out.println("Baking the pizza at 400 degrees for 25 minutes");
    }
}
