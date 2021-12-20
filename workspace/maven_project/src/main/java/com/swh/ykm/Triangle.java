package com.swh.ykm;

import com.swh.ykm.Rectangle;

class Triangle {
	protected int width;
	private int height;
	
	public void draw(){
		System.out.println("가로 " + width + ", 세로 " + height);
		Rectangle r = new Rectangle();
		int height = r.height;	//	정상
		System.out.println("높이 " + height);
	}
}