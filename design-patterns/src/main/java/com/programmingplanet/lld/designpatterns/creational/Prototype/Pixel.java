package com.programmingplanet.lld.designpatterns.creational.Prototype;

@lombok.AllArgsConstructor
public class Pixel {
    private int RED;
    private int GREEN;
    private int BLUE;

    public Pixel clone() {
        return new Pixel(RED, GREEN, BLUE);
    }

    public int[] getRGB() {
        return new int[] { RED, GREEN, BLUE };
    }
}
