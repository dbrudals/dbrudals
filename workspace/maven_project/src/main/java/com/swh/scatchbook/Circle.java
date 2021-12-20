package com.swh.scatchbook;

public class Circle extends Shape implements Drawing {

    protected int r;

    public Circle() {
        r = 0;
    }

    public Circle(int r) {
        this.r = r;
    }

    @Override
    public double area() {
        // TODO Auto-generated method stub
        return Math.PI * r * r;
    }
    
    public int draw() {
        // TODO Auto-generated method stub
        System.out.println(title + " : 원을 그립니다.");
        return 1;
    }
}