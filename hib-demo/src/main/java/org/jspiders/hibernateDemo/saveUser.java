package org.jspiders.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class saveUser {

	public static void main(String[] args) {

		User u = new User();
		
		u.setName("Kichak");
		u.setPhone(7286541258L);
		u.setEmail("kichak@dholakpur.com");
		u.setPassword("kichak@123");
		
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		int id = (Integer) s.save(u);
		
//		1st way
//      Transaction t = s.getTransaction();
//		t.begin();
//		t.commit();
		
		Transaction t = s.beginTransaction();
		t.commit();
		System.out.println("user saved with Id : "+id);
		
	}

}
