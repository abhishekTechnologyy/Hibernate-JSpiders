package org.jspiders.hibernateDemo;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class VerifyUserByPhoneAndPassword {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the phone number and password to verify");
		
		System.out.print("Enter Phone No. : ");
		long phone = sc.nextLong();
		
		System.out.print("Enter Password : ");
		String password = sc.next();
		
		Session s = new Configuration().configure().buildSessionFactory().openSession(); //method chaining
		
		Query<User> q = s.createQuery("select u from User u where u.phone = ?1 and u.password = :ps");
		
		q.setParameter(1, phone);
		q.setParameter("ps", password);
		
		try
		{
			User u = q.getSingleResult();
			System.out.println("Verification Successful");
			
			System.out.println("User Id : "+u.getId());
			System.out.println("User Name : "+u.getName());
			System.out.println("User Email : "+u.getEmail());
			System.out.println("User Phone : "+u.getPhone());
			System.out.println("User Password : "+u.getPassword());
		}
		catch(NoResultException exp)
		{
			System.err.println("Invalid Phone no. or Password");
		}

	}
}
