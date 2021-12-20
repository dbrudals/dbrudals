package com.swh.morpheme_project;

public class Morph {
	private int index;
	private String morph;
	private String pos;
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getMorph() {
		return morph;
	}
	public void setMorph(String morph) {
		this.morph = morph;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.index+1 +"번째 "+"형태소 : " + this.morph + " / 품사 : " + this.pos;
	}
}
