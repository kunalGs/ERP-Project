package com.example.esd_project.util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionUtil {
    //XML based configuration
    private static final SessionFactory sessionFactory;

    static {
        try {
            System.out.println("in try");
            Configuration configuration = new Configuration();
            System.out.println("in try 2");
            configuration.configure();
            System.out.println("in try 3");
            sessionFactory = configuration.buildSessionFactory();
            System.out.println("in try 4");
        } catch (Throwable ex) {
            System.out.println("Error in util");
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }
}
