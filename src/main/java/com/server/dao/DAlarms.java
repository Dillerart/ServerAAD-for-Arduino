package com.server.dao;


import com.server.controller.HibernateUtil;
import com.server.table.Alarms;
import org.hibernate.Session;

public class DAlarms {

    public void addAlarms(Alarms alarms){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(alarms);
            session.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(session !=null && session.isOpen()){
                session.close();
            }
        }
    }
}
