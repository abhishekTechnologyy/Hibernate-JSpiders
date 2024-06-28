package org.jspides.oneToOneUni;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePersonAndPanCard {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Person p = new Person();
		
		p.setName("Manendra Kumar");
		p.setPhone(9334201008L);
		
		PanCard card = new PanCard();
		
		card.setNumber("RHNXCP1808");
		card.setDob(LocalDate.parse("1975-01-01"));
		card.setPincode(800008);
		
		p.setCard(card);
		manager.persist(p);
		manager.persist(card);
		
		transaction.begin();
		transaction.commit();
	}

}
