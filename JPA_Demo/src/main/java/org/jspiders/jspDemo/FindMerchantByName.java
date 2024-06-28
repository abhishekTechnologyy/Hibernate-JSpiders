package org.jspiders.jspDemo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMerchantByName {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Merchant name to find the details");
		
		String name = sc.next();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select m from Merchant m where m.name = ?1");
		
		q.setParameter(1, name);
		
		List<Merchant> merchants = q.getResultList();
		
		if(merchants.size() > 0)
		{
			for(Merchant m : merchants)
			{
				System.out.println(m);
				System.out.println("-------------");
			}
		}
		else
		{
			System.err.println("No Merchant with entered name");
		}

	}

}
