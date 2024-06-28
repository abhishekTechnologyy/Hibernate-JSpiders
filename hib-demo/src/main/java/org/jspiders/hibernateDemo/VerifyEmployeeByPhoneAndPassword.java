package org.jspiders.hibernateDemo;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class VerifyEmployeeByPhoneAndPassword {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the phone number and password to verify");
		
		System.out.print("Enter Phone No. : ");
		long phone = sc.nextLong();
		
		System.out.print("Enter Password : ");
		String password = sc.next();
		
		Session s = new Configuration().configure().buildSessionFactory().openSession(); //method chaining
		
		Query<Employee> q = s.createQuery("select e from Employee e where e.phone = ?1 and e.password = :ps");
		
		q.setParameter(1, phone);
		q.setParameter("ps", password);
		
		try
		{
			Employee e = q.getSingleResult();
			System.out.println("Verification Successful");
			
			System.out.println("Employee ID : "+e.getId());
			System.out.println("Employee Name : "+e.getName());
			System.out.println("Employee Salary : "+e.getSalary());
			System.out.println("Employee Phone : "+e.getPhone());
			System.out.println("Employee Designation : "+e.getDesg());
		}
		catch(NoResultException exp)
		{
			System.err.println("Invalid Phone no. or Password");
		}

	}

}
