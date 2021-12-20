package com.swh.hibernate.annotation;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * <pre>
 * kr.co.swh.lecture.opensource.hibernate.annotation
 * Cart.java
 *
 * 설명 : 하이버네이트 어노테이션 예제1
 * </pre>
 * 
 * @since : 2017. 10. 26.
 * @author : tobby48
 * @version : v1.0
 */
public class Result {

    @Column(name = "cart_id")
    private long cart_id;
    
    @Column(name = "id")
    private long id;
    
    @Column(name = "item_cart_id")
    private long item_cart_id;

    public Result() {
		// TODO Auto-generated constructor stub
	}
    
	public long getCart_id() {
		return cart_id;
	}

	public void setCart_id(long cart_id) {
		this.cart_id = cart_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getItem_cart_id() {
		return item_cart_id;
	}

	public void setItem_cart_id(long item_cart_id) {
		this.item_cart_id = item_cart_id;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}