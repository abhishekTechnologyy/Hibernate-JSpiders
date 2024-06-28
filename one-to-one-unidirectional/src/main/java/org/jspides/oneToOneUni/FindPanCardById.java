package org.jspides.oneToOneUni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindPanCardById {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the PanCard Id to show the details of PanCard");
		int id = sc.nextInt();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		PanCard pc = manager.find(PanCard.class, id);
		
		if(pc != null)
		{
			System.out.println(pc.toString());
		}
		else
		{
			System.err.println("you have entered Invalid PanCard Id");
		}
	}

}
