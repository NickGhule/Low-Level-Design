package com.programmingplanet.lld.designpatterns.creational.Prototype;


@lombok.Getter
public abstract class BackgroundObject implements GraphicalObject{
    protected String color;
    protected int width;
    protected int height;
    protected Point position;
    protected Pixel[][] pixels = new Pixel[width][height];
    protected BackgroundObjectType type;

    public abstract BackgroundObject clone();
    public abstract void generate();

    public BackgroundObject setPosition(int x, int y) {
        this.position.setX(x);
        this.position.setY(y);
        return this;
    }
}
