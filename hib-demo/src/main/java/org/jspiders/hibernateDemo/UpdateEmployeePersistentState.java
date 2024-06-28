package org.jspiders.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateEmployeePersistentState {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		
		Employee e = s.get(Employee.class, 2); //Persistent state
		
		if(e != null)
		{
//			e.setName("xyz");
//			e.setDesg("SDE-2");
//			e.setSalary(10000);
//			e.setPassword("Aman@123");
//			e.setPhone(49894l);
			e.setDesg("PRODUCT MANAGER");
			
			Transaction t = s.beginTransaction();
			t.commit();
		}
		else
		{
			System.err.println("Invalid ID");
		}
			
	}

}
