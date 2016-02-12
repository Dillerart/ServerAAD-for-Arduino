package com.server.arduino;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ArduinoConfig {

    private String confPath = "config.properties";

    private FileInputStream fis;

    private String portName;

    private int timeOut;

    private int dataRate;

    private int timeSleep;

    private int t;

    private int p;

    private int rh;

    private int id_object;

    public ArduinoConfig() {
        Properties property = new Properties();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(confPath);
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(inputStream);
            this.portName = property.getProperty("arduino.connect.Port");
            this.timeOut = Integer.parseInt(property.getProperty("arduino.connect.TimeOut"));
            this.dataRate = Integer.parseInt(property.getProperty("arduino.connect.DataRate"));
            this.timeSleep = Integer.parseInt(property.getProperty("arduino.connect.TimeSleep"));
            this.t = Integer.parseInt(property.getProperty("arduino.object.temperature"));
            this.p = Integer.parseInt(property.getProperty("arduino.object.AtmospherePressure"));
            this.rh = Integer.parseInt(property.getProperty("arduino.object.humidity"));
            this.id_object = Integer.parseInt(property.getProperty("arduino.object.id_object"));
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }

    public int getT() {
        return t;
    }

    public int getP() {
        return p;
    }

    public int getRh() {
        return rh;
    }

    public int getId_object() {
        return id_object;
    }

    public String getPortName() {
        return portName;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public int getDataRate() {
        return dataRate;
    }

    public int getTimeSleep() {
        return timeSleep;
    }
}
