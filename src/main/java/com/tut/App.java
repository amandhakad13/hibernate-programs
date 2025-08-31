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
        
        s1.setId(102);
        s1.setName("Jaideep");
        s1.setAge(25);
        s1.setCity("Delhi");
        
        StudentAddress sa1 = new StudentAddress();
        
        sa1.setCity("Delhi");
        sa1.setStreet("2nd Street");
        sa1.setXyz(15.254);
        sa1.setOpen(false);
        sa1.setDate(LocalDate.of(2024, 7, 19));
        
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
