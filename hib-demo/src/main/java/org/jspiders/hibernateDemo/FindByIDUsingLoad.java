package org.jspiders.hibernateDemo;

import java.util.Scanner;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FindByIDUsingLoad {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the employee ID to print the details");
		
		int id = sc.nextInt();
		
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		
		Employee e = s.load(Employee.class, id);
		
		try
		{
			System.out.println("Employee Id : "+e.getId());
			System.out.println("Employee Name : "+e.getName());
			System.out.println("Employee Salary : "+e.getSalary());
			System.out.println("Employee Phone : "+e.getPhone());
			System.out.println("Employee Designation : "+e.getDesg());
		}
		
		catch (ObjectNotFoundException exp) 
		{
			
			System.err.println("you have entered an invalid Employee ID");
		}
	}

}
