package com.example.app;

import com.example.entity.Citizen;
import com.example.entity.Passport;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
        Passport passport = new Passport();
        passport.setPassportNumber("P123456789");

        Citizen citizen = new Citizen();
        citizen.setName("John Doe");
        citizen.setPassport(passport);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(citizen);

        tx.commit();
        session.close();

        System.out.println("Citizen and Passport saved successfully.");
    }
}