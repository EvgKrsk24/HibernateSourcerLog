package ru.java.hibernate;//из документации. Для считывания hibernate.cfg.xml


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil { // java class for initialization hibernate

    private static final SessionFactory sessionFactory = buildSessionFactory();

    // вызывается автоматически тк вызывается из статичной переменной
    private static SessionFactory buildSessionFactory() {
        try {
            // return new Configuration().configure(new File("scr\\main\\resources\\hibernate.cfg.xml")).buildSessionFactory();
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
// вызываем при потребности в SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    //закрываем все соединения
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
