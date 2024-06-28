package org.jspiders.jspDemo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMerchant {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the name, Gst number, phone number, email and password");
		
		Merchant m = new Merchant();
		
		m.setName(sc.next());
		m.setGst_number(sc.next());
		m.setPhone(sc.nextLong());
		m.setEmail(sc.next());
		m.setPassword(sc.next());
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		manager.persist(m);
		
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();
		
		System.out.println("Merchant saved with Id: "+m.getId());
		
	}

}
 