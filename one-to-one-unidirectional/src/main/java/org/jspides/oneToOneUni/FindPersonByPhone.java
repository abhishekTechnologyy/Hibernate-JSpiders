package org.jspides.oneToOneUni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByPhone {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Person Phone No. to find the details");
		
		long phone = sc.nextLong();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select p from Person p where p.phone = ?1");
		
		q.setParameter(1, phone);
		
		Person person = (Person) q.getSingleResult();
		
		if(person != null)
		{
			System.out.println(person.toString());
		}
		else
		{
			System.err.println("No Merchant with entered phone");
		}

	}

}
