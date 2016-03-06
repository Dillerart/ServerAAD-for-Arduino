package com.server;

import com.server.arduino.ArduinoConnector;


public class Project {

    public static void main(String[] args){

        ArduinoConnector arduinoConnector = new ArduinoConnector();

        Thread t = new Thread(arduinoConnector);

        //Стартуем чтение данных с Ардуино + запись данных в БД.
        t.start();
    }
}
