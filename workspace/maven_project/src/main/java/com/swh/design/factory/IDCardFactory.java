package com.swh.design.factory;

import java.util.Vector;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class IDCardFactory extends Factory {
	private Vector owners = new Vector(); //Vector 객체 생성
	
	protected Product createProduct(String owner){
		return new IDCard(owner); // IDCard의 객체 생성 but 리턴 타입은 Product
	}
	protected void registerProduct(Product product){ // 리턴 타입 없는 메소드
		owners.add(((IDCard)product).getOwner());
		// IDCard 객체가 부모로 형변환되었던것을
		// 명시적으로 다시 자식으로 형변환 후 자식의 함수 사용
		// ------------돌쌤 왈-------------
	    // Product는 제품이고, 해당 제품은 IDCard클래스로 만들어진 객체(간단히 ID카드의 부모클래스인 추상클래스가 Product) 이므로 
	    // 부모인 Product은 자식인 IDCard형으로 변환해야 getOwner함수를 호출할 수 있기 때문에 형변환 한 것임.

		
	}
	public Vector getOwners(){
		return owners; //getter
	}
}