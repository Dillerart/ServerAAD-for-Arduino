package com.server.controller;


import com.server.dao.DEventsLog;

public class Factory {

    private static Factory instanse = null;

    private DEventsLog dEventsLog = null;

    //Получаем инстанс
    public static synchronized Factory getInstanse(){
        if(instanse == null){
            instanse = new Factory();
        }
        return instanse;
    }

    //Получаем DAO
    public DEventsLog getdEventsLog() {
        if(dEventsLog == null){
            dEventsLog = new DEventsLog();
        }
        return dEventsLog;
    }


}
