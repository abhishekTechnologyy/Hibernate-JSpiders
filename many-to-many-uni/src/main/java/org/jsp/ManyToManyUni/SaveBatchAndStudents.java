package org.jsp.ManyToManyUni;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveBatchAndStudents {

	public static void main(String[] args) {
		Student s1=new Student();
		s1.setName("Abhishek");
		s1.setPhone(1228288288L);
		s1.setPerc(95);
		
		Student s2=new Student();
		s2.setName("Kusum");
		s2.setPhone(12282432288L);
		s2.setPerc(55);
		
		Student s3=new Student();
		s3.setName("Aashutosh");
		s3.setPhone(12283228288L);
		s3.setPerc(85);
		
		Batch b1=new Batch();
		b1.setSubject("Java");
		b1.setTrainer("Keshav sir");
		b1.setBatch_code("CJD-A6");
		
		Batch b2=new Batch();
		b2.setSubject("SQL");
		b2.setTrainer("Sharath sir");
		b2.setBatch_code("CJD-A11");
		
		Batch b3=new Batch();
		b3.setSubject("JDBC");
		b3.setTrainer("Guru sir");
		b3.setBatch_code("CJD-A23");
		
		Batch b4=new Batch();
		b4.setSubject("SQL");
		b4.setTrainer("Swetha mam");
		b4.setBatch_code("CJD-A2");
		
		b1.setStudents(Arrays.asList(s1,s2,s3));
		b2.setStudents(Arrays.asList(s1,s2,s3));
		b3.setStudents(Arrays.asList(s1,s3));
		b4.setStudents(Arrays.asList(s2,s3));
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);
		manager.persist(b4);
		transaction.begin();
		transaction.commit();
	
	}

}
