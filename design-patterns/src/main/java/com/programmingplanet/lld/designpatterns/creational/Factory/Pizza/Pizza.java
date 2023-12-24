package com.programmingplanet.lld.designpatterns.creational.Factory.Pizza;

public abstract class Pizza {
    int size;
    String name;

    public void prepare() {
        addToppings();
        bake();
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public abstract void addToppings();
    public abstract void bake();
}
