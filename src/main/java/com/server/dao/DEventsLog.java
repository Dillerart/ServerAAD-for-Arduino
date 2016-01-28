package com.server.dao;


import com.server.controller.HibernateUtil;
import com.server.table.EventsLog;
import org.hibernate.Session;

public class DEventsLog {

    public void addEventsLog(EventsLog eventsLog){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(eventsLog);
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
