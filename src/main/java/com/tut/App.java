package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
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
        
        StudentAddress sa1 = new StudentAddress();
        
        sa1.setCity("Indore");
        sa1.setStreet("1st Street");
        sa1.setXyz(12.125);
        sa1.setOpen(true);
        sa1.setDate(LocalDate.of(2025, 8, 29));
        
        FileInputStream fis = new FileInputStream("src/main/java/presentation_img.jpg");
        byte[] b = new byte[fis.available()];
        fis.read();
        sa1.setImage(b);
        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
        session.persist(s1);
        session.persist(sa1);
        
        tx.commit();
        session.close();
        fis.close();
    }
}
