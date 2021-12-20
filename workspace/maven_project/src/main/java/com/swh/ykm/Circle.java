package com.swh.ykm;

import com.swh.ykm.Rectangle;

public class Circle extends Triangle{
	protected int radius;
	
	public void draw(){
		System.out.println("반지름 " + radius);
		Rectangle r = new Rectangle();
		int cHeight = r.height;		//	정상
		Triangle t = new Triangle();	//	정상
//		cHeight = t.height;		//	오류
//		cHeight = height;		//	오류
		int cWidth = t.width;	//	정상
		cWidth = width;		//	정상
		int width = t.width;		//	정상
		
	}
}
