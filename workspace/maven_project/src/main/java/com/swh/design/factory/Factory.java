package com.swh.design.factory;

public abstract class Factory {
	public final Product create(String owner){ // 리턴 타입이 Product인 메소드
		Product p = createProduct(owner); 
		// IDCardFactory에 오버라이딩된 함수 실행 // IDCard의 객체가 생성됨
		registerProduct(p); // IDCardFactory에 오버라이딩된 메소드 실행
		return p; // Product 타입의 객체 리턴
	}
	protected abstract Product createProduct(String owner); // 추상메소드 /강제성
	protected abstract void registerProduct(Product product); // 추상메소드
}