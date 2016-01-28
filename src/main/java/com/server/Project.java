package com.server;


import com.server.controller.Factory;
import com.server.controller.HibernateUtil;
import com.server.table.Alarms;
import com.server.table.EventsLog;
import com.server.table.Measurement;
import com.server.table.Sensor;

public class Project {

    private static Alarms alarms = null;

    private static EventsLog eventsLog = null;

    private static Measurement measurement = null;

    private static Sensor sensor = null;

    public static void main(String[] args) {

        measurement = new Measurement();
        measurement.setMeasurement("Пожар");
        Factory.getInstanse().getdMeasurement().addMeasurement(measurement);

    }
}
