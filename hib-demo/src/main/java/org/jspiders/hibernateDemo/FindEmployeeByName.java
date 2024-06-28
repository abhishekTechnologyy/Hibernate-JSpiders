package org.jspiders.hibernateDemo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindEmployeeByName {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the employee name to print the details");
		String name = sc.nextLine(); //agar next() likhenge to sirf ek word hi likh skte h.. so nextLine().
		
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		
		Query<Employee> q = s.createQuery("select e from Employee e where e.name = :empName");
		q.setParameter("empName", name);
		
		
			List<Employee> emps = q.getResultList();
			System.out.println("Verification Successful");
			if(emps.size()>0)
			for(Employee e:emps) {
			System.out.println("Employee ID : "+e.getId());
//			System.out.println("Employee Name : "+e.getName());
			System.out.println("Employee Salary : "+e.getSalary());
			System.out.println("Employee Phone : "+e.getPhone());
			System.out.println("Employee Designation : "+e.getDesg());
		}
			else
		{
			System.err.println("Invalid Name");
		}
	}

}
