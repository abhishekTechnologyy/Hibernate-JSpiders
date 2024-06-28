package org.jspides.oneToOneUni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class FindPersonByName {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Person name to find the details");
		
		String name = sc.nextLine();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select p from Person p where p.name = ?1");
		
		q.setParameter(1, name);
		
		List<Person> persons = q.getResultList();
		
		if(persons.size() > 0)
		{
			for(Person p : persons)
			{
				System.out.println(p);
				System.out.println("-------------");
			}
		}
		else
		{
			System.err.println("No Merchant with entered name");
		}
	}
}
