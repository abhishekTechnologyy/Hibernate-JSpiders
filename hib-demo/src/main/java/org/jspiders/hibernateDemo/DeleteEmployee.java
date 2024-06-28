package org.jspiders.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteEmployee {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		
		Employee e = s.get(Employee.class, 30);
		
		if(e != null)
		{
			s.delete(e);
			Transaction t = s.beginTransaction();
			t.commit();
		}
		else
		{
			System.err.println("can't delete as ID is invalid");
		}
	}

}
