package com.programmingplanet.lld.designpatterns.creational.Prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Point{
    private int x;
    private int y;

    public Point clone() {
        return new Point(x, y);
    }
}
