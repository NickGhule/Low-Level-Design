package com.programmingplanet.lld.designpatterns.creational.Factory.Pizza;

public class VeggiePizza extends Pizza{
    public VeggiePizza() {
        this.name = "Veggie Pizza";
        this.size = 12;
    }

    @Override
    public void addToppings() {
        System.out.println("Adding veggie toppings");
    }

    @Override
    public void bake() {
        System.out.println("Baking the pizza at 400 degrees for 30 minutes");
    }
}
