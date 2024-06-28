package org.jspiders.oneToManyUni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveDepartmentAndEmployees {

	public static void main(String[] args) {

		Department d = new Department();
		d.setName("Development");
		d.setLocation("BTM Layout");
		
		Employee e1 = new Employee();
		e1.setName("Abhishek Sinha");
		e1.setDesg("Developer");
		e1.setSalary(876543);
		
		Employee e2 = new Employee();
		e2.setName("Kusum Singh");
		e2.setDesg("Senior Developer");
		e2.setSalary(8765430);
		
		Employee e3 = new Employee();
		e3.setName("Ashutosh Sinha");
		e3.setDesg("Project Manager");
		e3.setSalary(9765432);
		
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);

		d.setEmps(emps);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		manager.persist(d);
		transaction.begin();
		transaction.commit();
		
		
	}

}
