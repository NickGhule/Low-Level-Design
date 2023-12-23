package com.programmingplanet.lld.designpatterns.creational.Prototype;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class TreeTest {
    @Test
    public void testClone() {
        Tree tree1 = new Tree("Green", 10, 20, new Point(0, 0));
        Tree tree2 = tree1.clone();

        tree2.setPosition(10, 10);

        assertNotSame("If the tree is cloned, the object should not be same", tree1, tree2);
        assertNotSame("If object is cloned, the position should not be the same", tree1.getPosition(), tree2.getPosition());
        assertSame("If object is cloned, the Pixels should be the same", tree1.getPixels(), tree2.getPixels());
    }
}
