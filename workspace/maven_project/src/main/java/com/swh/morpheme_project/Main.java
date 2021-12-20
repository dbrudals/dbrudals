package com.swh.morpheme_project;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		Work w = new Work();
//		Db db = new Db();
		List<Sentence> senList = w.work("아버지가방에들어가신다.안녕하세요.그만해주세요?너랑안놀고싶어미안해.");
		for (Sentence s : senList){
			System.out.println(s);
			for (Eojjeol e : s.getEojList()){
				System.out.println("\t"+e);
				for (Morph m : e.getMorList()){
					System.out.println("\t"+"\t"+m);
				}
			}
		}
	}
}
