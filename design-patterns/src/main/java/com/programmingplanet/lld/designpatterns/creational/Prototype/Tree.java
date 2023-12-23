package com.programmingplanet.lld.designpatterns.creational.Prototype;


public class Tree extends BackgroundObject {

    public Tree(String color, int width, int height, Point position) {
        this.type = BackgroundObjectType.TREE;
        this.color = color;
        this.width = width;
        this.height = height;
        this.position = position;
        this.pixels = new Pixel[width][height];
        this.generate();
    }

    // Copy constructor
    public Tree(Tree tree) {
        this.type = tree.type;
        this.color = tree.color;
        this.width = tree.width;
        this.height = tree.height;
        this.position = tree.position.clone();  // Deep copy
        this.pixels = tree.pixels;              // Shallow copy
    }
    
    public void generate() {
        // Generate tree pixels based on width and height
        // Time consuming operation = O(width * height)
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                pixels[i][j] = new Pixel(0, 255, 0);
            }
        }
    }

    // Non time consuming operation = O(1)
    public Tree clone() {
        Tree tree = new Tree(this);
        return tree;
    }
}
