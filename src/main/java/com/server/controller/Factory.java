package com.server.controller;


import com.server.dao.DAlarms;
import com.server.dao.DEventsLog;
import com.server.dao.DMeasurement;
import com.server.dao.DSensor;

public class Factory {

    private static Factory instanse = null;

    private DAlarms dAlarms = null;

    private DEventsLog dEventsLog = null;

    private DMeasurement dMeasurement = null;

    private DSensor dSensor = null;

    public static synchronized Factory getInstanse(){
        if(instanse == null){
            instanse = new Factory();
        }
        return instanse;
    }

    public DAlarms getdAlarms() {
        if(dAlarms == null){
            dAlarms = new DAlarms();
        }
        return dAlarms;
    }

    public DEventsLog getdEventsLog() {
        if(dEventsLog == null){
            dEventsLog = new DEventsLog();
        }
        return dEventsLog;
    }

    public DMeasurement getdMeasurement() {
        if(dMeasurement == null){
            dMeasurement = new DMeasurement();
        }
        return dMeasurement;
    }

    public DSensor getdSensor() {
        if(dSensor == null){
            dSensor = new DSensor();
        }
        return dSensor;
    }
}
