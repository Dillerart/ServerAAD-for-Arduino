package com.server.dao;


import com.server.controller.HibernateUtil;
import com.server.table.Sensor;
import org.hibernate.Session;

public class DSensor {

    public void addSensor(Sensor sensor){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(sensor);
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
