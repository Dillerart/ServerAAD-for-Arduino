package com.server.controller;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static SessionFactory sessionFactory = null;

    //Получаем сессию через конфиг(hibernate.cfg.xml)
    static {
        try{
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //Возвращаем сессию.
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
