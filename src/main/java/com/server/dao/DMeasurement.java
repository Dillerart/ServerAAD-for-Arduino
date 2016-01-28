package com.server.dao;


import com.server.controller.HibernateUtil;
import com.server.table.Measurement;
import org.hibernate.Session;

public class DMeasurement {

    public void addMeasurement(Measurement measurement){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(measurement);
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
