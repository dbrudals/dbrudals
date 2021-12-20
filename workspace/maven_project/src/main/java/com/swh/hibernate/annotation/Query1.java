package com.swh.hibernate.annotation;


import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Query1 {
	public static void main( String[] args ){
		SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();

		Cart cart = new Cart();
		Items item1 = new Items(cart);
		Items item2 = new Items(cart);
		Set<Items> itemsSet = new HashSet<Items>();
		itemsSet.add(item1);
		itemsSet.add(item2);
		cart.setItems(itemsSet);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(cart);
		session.save(item1);
		session.save(item2);
		session.getTransaction().commit();
		System.out.println("Insert completed");

		System.out.println("Cart ID=" + cart.getId());
		System.out.println("item1 ID=" + item1.getId() + ", Foreign Key Cart ID=" + item1.getCart().getId());
		System.out.println("item2 ID=" + item2.getId() + ", Foreign Key Cart ID=" + item1.getCart().getId());

		session.close();
		sessionFactory.close();
	}
}