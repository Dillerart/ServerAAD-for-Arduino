package com.server;

import com.server.arduino.ArduinoConnector;
import sun.util.calendar.LocalGregorianCalendar;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Project {

    public static void main(String[] args){

        ArduinoConnector arduinoConnector = new ArduinoConnector();

        Thread t = new Thread(arduinoConnector);

        t.start();
    }
}
