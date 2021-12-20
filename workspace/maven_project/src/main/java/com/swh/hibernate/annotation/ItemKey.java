package com.swh.hibernate.annotation;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

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
@Embeddable
public class ItemKey implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	private int id;
	private String name;
	
	public ItemKey() {
		// TODO Auto-generated constructor stub
	}
	public ItemKey(int id, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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