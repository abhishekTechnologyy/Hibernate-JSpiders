package org.jspiders.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateUser {

	public static void main(String[] args) {

			Configuration cfg = new Configuration().configure();
			SessionFactory factory = cfg.buildSessionFactory();
			Session s = factory.openSession();
			
			User u = s.get(User.class, 1); //Persistent state
			
			if(u != null)
			{
//				e.setName("xyz");
//				e.setDesg("SDE-2");
//				e.setSalary(10000);
//				e.setPassword("Aman@123");
//				e.setPhone(49894l);
				u.setPhone(7286541253L);
				
				Transaction t = s.beginTransaction();
				t.commit();
			}
			else
			{
				System.err.println("Invalid ID");
			}
	}

}
