package com.programmingplanet.lld.designpatterns.creational.Factory.Pizza;

public class PizzaFactory {
    
        public static Pizza createPizza(String type) {
            if (type.equals("cheese")) {
                return new CheesePizza();
            } else if (type.equals("pepperoni")) {
                return new PepperoniPizza();
            } else if (type.equals("veggie")) {
                return new VeggiePizza();
            } else {
                return null;
            }
        }
}
