package com.swh.ykm;

import com.swh.ykm.Circle;

public class Rectangle {
	protected int width;
	public int height;
	
	public void draw(){
		System.out.println("가로 " + width + ", 세로 " + height);
		Circle c = new Circle();
//		c.radius;		//	오류
		c.draw();			//	정상
//		Triangle t = new Triangle();	//	오류
		
	}
}