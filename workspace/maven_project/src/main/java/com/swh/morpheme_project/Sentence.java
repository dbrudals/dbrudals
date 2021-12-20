package com.swh.morpheme_project;

import java.util.List;

public class Sentence {
	private int index;
	private String contents;
	private List<Eojjeol> eojList;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public List<Eojjeol> getEojList() {
		return eojList;
	}

	public void setEojList(List<Eojjeol> list) {
		this.eojList = list;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.index+1 + "번째 문장입니다 : " + this.contents;
	}

}