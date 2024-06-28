package org.jspiders.hibernateDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindAllEmployees {

	public static void main(String[] args) {

//		Configuration cfg = new Configuration().configure();
//		SessionFactory factory = cfg.buildSessionFactory();
//		Session s = factory.openSession(); 
//      itna likhne se accha hai method chaining
		
		Session s = new Configuration().configure().buildSessionFactory().openSession(); //method chaining
		
		Query<Employee> q = s.createQuery("select e from Employee e");
		
		List<Employee> emps = q.getResultList();
		
		if(emps.size() > 0)
		{
			for(Employee e : emps)
			{
				System.out.println("Employee ID : "+e.getId());
				System.out.println("Employee Name : "+e.getName());
				System.out.println("Employee Salary : "+e.getSalary());
				System.out.println("Employee Phone : "+e.getPhone());
				System.out.println("Employee Designation : "+e.getDesg());
				System.out.println("---------------------------------------");

			}
		}
		else
		{
			System.err.println("Cannot Find any Employee");
		}
	}

}
