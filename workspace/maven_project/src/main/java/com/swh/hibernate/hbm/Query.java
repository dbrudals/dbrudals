package com.swh.hibernate.hbm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Query {
	public static void main(String[] args){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		SWHAcademy myuser = (SWHAcademy)session.get(SWHAcademy.class, "key");
		System.out.println("name:"+myuser.getName());
		myuser.setName("SWHAcademy");
		session.getTransaction().commit();

		session.close();
		sessionFactory.close();
	}
}