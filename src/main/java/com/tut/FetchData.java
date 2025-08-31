package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		Student s1 = (Student)session.find(Student.class, 102);
		System.out.println("Name : "+s1.getName());
		System.out.println("Age : "+s1.getAge());
		System.out.println("City : "+s1.getCity());
	}
}
