package com.programmingplanet.lld.designpatterns.creational.Factory;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.programmingplanet.lld.designpatterns.creational.Factory.Pizza.*;

public class PizzaFactoryTest {
    @Test
    public void testPizzaFactory() {
        Pizza cheesePizza = PizzaFactory.createPizza("cheese");
        Pizza pepperoniPizza = PizzaFactory.createPizza("pepperoni");
        Pizza veggiePizza = PizzaFactory.createPizza("veggie");

        cheesePizza.prepare();
        cheesePizza.cut();

        pepperoniPizza.prepare();
        pepperoniPizza.cut();

        veggiePizza.prepare();
        veggiePizza.cut();

        assertTrue("If cheese pizza is created, then the PizzaFactory should return an instance of CheesePizza", cheesePizza instanceof CheesePizza);
        assertTrue("If pepperoni pizza is created, then the PizzaFactory should return an instance of PepperoniPizza", pepperoniPizza instanceof PepperoniPizza);
        assertTrue("If veggie pizza is created, then the PizzaFactory should return an instance of VeggiePizza", veggiePizza instanceof VeggiePizza);
    }
}
