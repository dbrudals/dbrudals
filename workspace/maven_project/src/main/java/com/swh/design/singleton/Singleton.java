package com.swh.design.singleton;

public class Singleton {

	private static Singleton singleton = new Singleton();

	private Singleton(){
		System.out.println("인스턴스를 생성했습니다.");
	}
	public static Singleton getInstance(){
		System.out.println("인스턴스를 반환합니다.");
		return singleton;
	}
}