package org.jspiders.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		
		Employee e = new Employee(); //Transient state
		
		e.setId(30);
		e.setName("Pushpa");
		e.setDesg("Smuggler");
		e.setSalary(55000);
		e.setPhone(82545L);
		e.setPassword("srri valli");
		
		s.update(e);
		
		Transaction t = s.beginTransaction();
		t.commit();
	}
}
