package com.swh.design.factory;

public class Main {
	public static void main(String[] args) {
		Factory factory = new IDCardFactory(); // 부모인 Factory로 암묵적 형변환
		Product card1 = factory.create("코야"); // 부모인 Factory 클래스의 create 메소드
		Product card2 = factory.create("레종"); // factory.create 의 리턴값을 저장 
		Product card3 = factory.create("유키");
		card1.use(); // IDCard의 use 메소드 실행
		card2.use();  
		card3.use();
	}
}