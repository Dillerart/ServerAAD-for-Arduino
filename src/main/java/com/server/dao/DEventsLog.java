package com.server.dao;


import com.server.controller.HibernateUtil;
import com.server.table.EventsLog;
import org.hibernate.Session;

//DAO обработка событи(запись в БД)
public class DEventsLog {

    //передаем экземпляр Таблицы Событий и записываем в БД
    public void addEventsLog(EventsLog eventsLog){
        Session session = null;
        try {
            //Открываем сессию
            session = HibernateUtil.getSessionFactory().openSession();
            //Открываем транзакцию
            session.beginTransaction();
            //Записываем в БД.
            session.save(eventsLog);
            //Сохраняем данное событие.
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
