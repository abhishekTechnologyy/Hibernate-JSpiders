package org.jspiders.jspDemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateMerchant {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Merchant m = manager.find(Merchant.class, 2);
		
		m.setPassword("shivKumar@123");
		m.setPhone(98765678432L);
		m.setEmail("shivam@gmail.com");
		m.setName("Shivam");
		
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		transaction.commit();

	}

}
