package com.swh.scatchbook;

public abstract class Shape {
    protected int  x, y;

    public abstract double area();
    public void move(int x1, int y1) {
        x += x1;
        y += y1;
    }
}