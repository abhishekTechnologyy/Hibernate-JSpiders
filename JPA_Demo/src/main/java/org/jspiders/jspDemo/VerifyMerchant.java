package org.jspiders.jspDemo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class VerifyMerchant {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Phone no. and password");
		
		long phone = sc.nextLong();
		String password = sc.next();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select m from Merchant m where m.phone = ?1 and m.password = :ps");
		
		q.setParameter(1, phone);
		q.setParameter("ps", password);
		
		try 
		{
			
			Merchant m = (Merchant) q.getSingleResult();
			System.out.println("verification successful");
			System.out.println(m);
			
		} 
		catch (NoResultException e) 
		{
			System.err.println("Invalid phone no. or password");
		}
	}

}
