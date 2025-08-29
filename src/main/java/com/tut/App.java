package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Test Started" );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Student s1 = new Student();
        
        s1.setId(101);
        s1.setName("Avinash");
        s1.setAge(20);
        s1.setCity("Indore");
        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
        session.persist(s1);
        
        tx.commit();
        session.close();
    }
}
