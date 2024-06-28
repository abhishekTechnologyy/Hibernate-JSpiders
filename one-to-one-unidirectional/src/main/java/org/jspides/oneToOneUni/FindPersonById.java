package org.jspides.oneToOneUni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindPersonById {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Person Id to show the details of Person");
		int id = sc.nextInt();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Person p = manager.find(Person.class, id);
		
		if(p != null)
		{
			System.out.println(p.toString());
		}
		else
		{
			System.err.println("you have entered Invalid Person Id");
		}
	}

}
