package com.swh.hibernate.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * <pre>
 * kr.co.swh.lecture.opensource.hibernate.annotation
 * Query1.java
 *
 * 설명 : 하이버네이트 어노테이션 예제1 테스트
 * </pre>
 * 
 * @since : 2017. 10. 26.
 * @author : tobby48
 * @version : v1.0
 */
public class Query3 {
	public static void main( String[] args ){
        SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();

        CompositeCart cart = new CompositeCart();
        ItemKey key = new ItemKey(1, "테스트입니다.");
        cart.setId(key);
        cart.setUu("abc");
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(cart);
        session.getTransaction().commit();
        System.out.println("Insert completed");

        session.close();
        
        sessionFactory.close();
    }
}