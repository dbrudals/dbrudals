package com.swh.design.factory;
public class IDCard extends Product {
	private String owner;

	public IDCard(String owner){ // 생성자
		System.out.println(owner + "의 카드를 만듭니다."); // 출력
		this.owner = owner; // 오너 설정
	}
	public void use(){ // Product 메소드 오버라이딩
		System.out.println(owner + "의 카드를 사용합니다."); // 생성자에서 정의된 owner 사용;
	}
	public String getOwner(){ // getter
		return owner; 
	}
}