package com.swh.hibernate.annotation;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 * <pre>
 * kr.co.swh.lecture.opensource.hibernate.annotation
 * Query2.java
 *
 * 설명 : 하이버네이트 어노테이션 예제2 테스트
 * </pre>
 * 
 * @since : 2017. 10. 26.
 * @author : tobby48
 * @version : v1.0
 */
public class Query4 {

	private static SessionFactory sessionFactory; 
	

	public void listPerson( ){
		Session session = sessionFactory.openSession();
		try {
//			List<Result> list = session.createQuery("select a.id as cart_id, b.id as id, b.cart as item_cart_id from Cart a, Items b where a.id = b.cart", Result.class).getResultList();
			List<Items> list = session.createQuery("select b from Cart a, Items b where a.id = b.cart", Items.class).getResultList();
			Iterator<Items> iterator = list.iterator();
			while(iterator.hasNext()){
				Items i = iterator.next(); 
				System.out.println("id: " + i.getId()); 
				System.out.println("Cart: " + i.getCart()); 
				Cart c= i.getCart();
				System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}
	
	public void listPerson1( ){
		Session session = sessionFactory.openSession();
		try {
//			Iterator<Result> iterator = session.createQuery("sinum.siname, sidogunnum.citynum, sidogunnum.sidoname from sinum as A, sidogunnum as B where A.areanum = B.areanum", Result.class).list().iterator();
			Iterator<Object> iterator = session.createQuery("select sinum.siname, sidogunnum.citynum, sidogunnum.sidoname from sinum inner join sidogunnum on sinum.areanum = sidogunnum.areanum", Object.class).list().iterator();
			while(iterator.hasNext()){
				Result person = (Result) iterator.next(); 
//				System.out.print("City Name: " + person.getCitynum()); 
//				System.out.print("Sido Name: " + person.getSidoname()); 
//				System.out.println("Si Name: " + person.getSiname()); 
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}
	
	public void getPerson(String name){
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("FROM CompositeCart Where test=:name");
            query.setParameter("name", name);
            Iterator<CompositeCart> iterator = query.getResultList().iterator();
			while(iterator.hasNext()){
				CompositeCart person = (CompositeCart) iterator.next(); 
				System.out.print("uu: " + person.getUu()); 
				System.out.print("id: " + person.getId()); 
			}
		} catch (HibernateException e) {
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}

	public static void main( String[] args ){
		sessionFactory = HibernateAnnotationUtil.getSessionFactory();

		Query4 query = new Query4();
		
		query.listPerson();
		query.getPerson("abc");
		
		sessionFactory.close();
	}
}