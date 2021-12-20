package com.swh.hibernate.annotation;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Entity
@Table(name = "CompositeCart")
public class CompositeCart {

	@EmbeddedId
    @Column(name = "pk")
    private ItemKey id;
    
    @Column(name = "test")
    private String uu;	
    
    public CompositeCart() {
		// TODO Auto-generated constructor stub
	}

    public ItemKey getId() {
        return id;
    }

    public void setId(ItemKey id) {
        this.id = id;
    }

	public String getUu() {
		return uu;
	}

	public void setUu(String uu) {
		this.uu = uu;
	}

}