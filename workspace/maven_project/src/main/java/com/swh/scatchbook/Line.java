package com.swh.scatchbook;
public class Line extends Shape{

    protected int startX;

    public Line() {
        startX = 0;
    }

    public Line(int startX) {
        this.startX = startX;
    }

    @Override
    public double area() {
        // TODO Auto-generated method stub
        return startX;
    }

    public int draw() {
//      System.out.println(title + " : 원을 그립니다.");      //  오류, 인터페이스를 선언하지 않았다.
        return 0;
    }
}