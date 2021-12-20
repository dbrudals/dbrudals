package com.swh.scatchbook;
public class Rectangle extends Shape implements Drawing {

	protected int x, y;

	public Rectangle() {
		x = 0;
		y = 0;
	}

	public Rectangle(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return x * y;
	}

	public int draw() {
		// TODO Auto-generated method stub
		System.out.println(title + " : 사각형을 그립니다.");
		return 1;
	}
}