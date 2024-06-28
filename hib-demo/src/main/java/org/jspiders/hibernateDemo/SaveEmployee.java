package org.jspiders.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveEmployee {

	public static void main(String[] args) {
		
		Employee e = new Employee();
		
		e.setDesg("SOFTWARE DEVELOPER");
		e.setName("Kusum Singh");
		e.setPhone(8101178994L);
		e.setSalary(65000);
		e.setPassword("kusum@123");
		
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		int id = (Integer) s.save(e);
		
//		1st way
//      Transaction t = s.getTransaction();
//		t.begin();
//		t.commit();
		
		Transaction t = s.beginTransaction();
		t.commit();
		System.out.println("Employee saved with Id : "+id);
		
		
	}
}
