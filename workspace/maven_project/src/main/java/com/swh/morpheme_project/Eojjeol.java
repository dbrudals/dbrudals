package com.swh.morpheme_project;

import java.util.List;


public class Eojjeol {
	private int index;
	private String eojeol;
	private List<Morph> morList;

	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getEojeol() {
		return eojeol;
	}
	public void setEojeol(String eojeol) {
		this.eojeol = eojeol;
	}
	public List<Morph> getMorList() {
		return morList;
	}
	public void setMorList(List<Morph> list) {
		this.morList = list;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.index+1 +"번째 어절입니다 : " + this.eojeol;
	}

}