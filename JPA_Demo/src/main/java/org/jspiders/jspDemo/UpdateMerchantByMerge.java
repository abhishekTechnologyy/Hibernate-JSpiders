package org.jspiders.jspDemo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateMerchantByMerge {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the id , name , gst_number , phone , email , password");
		
		Merchant m = new Merchant();
		
		m.setId(sc.nextInt());
		m.setName(sc.next());
		m.setGst_number(sc.next());
		m.setPhone(sc.nextLong());
		m.setEmail(sc.next());
		m.setPassword(sc.next());
		

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		m = manager.merge(m);
		
		EntityTransaction transaction = manager.getTransaction();	
		
		transaction.begin();
		transaction.commit();
		
		System.out.println("Merchant updated with id : "+m.getId());
	}

}
