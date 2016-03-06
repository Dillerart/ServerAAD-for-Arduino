package com.server.arduino;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.*;

import com.server.controller.Factory;
import com.server.table.EventsLog;
import gnu.io.*;

//Получаем данные с Arduino
public class ArduinoConnector implements Runnable {

    private BufferedReader bRead = null;

    private int TIME_OUT;

    private int DATA_RATE;

    private SerialPort serialPort;

    private int TimeSleep;

    private String PORT_NAME;

    private int t;

    private int p;

    private int rh;

    private int id_object;

    public ArduinoConnector() {
        ArduinoConfig arduinoConfig = new ArduinoConfig();
        this.TIME_OUT = arduinoConfig.getTimeOut();
        this.DATA_RATE = arduinoConfig.getDataRate();
        this.PORT_NAME = arduinoConfig.getPortName();
        this.TimeSleep = arduinoConfig.getTimeSleep();
        this.t = arduinoConfig.getT();
        this.p = arduinoConfig.getP();
        this.rh = arduinoConfig.getRh();
        this.id_object = arduinoConfig.getId_object();
    }

    //Запуск потока чтения данных с Ардуино, и передача данных в БД через Hibernate
    public void run() {
        CommPortIdentifier portID = null;
        try {
            portID = CommPortIdentifier.getPortIdentifier(PORT_NAME);
            serialPort = (SerialPort) portID.open(this.getClass().getName(), TIME_OUT);
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            //Считываем поток с Ардуино.
            bRead = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            //Цикл, пока программа работает мы передаем данные из Ардуино в БД, с задеркой по времени.
            while (true) {
                setValueDav(Double.parseDouble(bRead.readLine()));
                setValueTemp(Double.parseDouble(bRead.readLine()));
                setValueRH(Double.parseDouble(bRead.readLine()));
                Thread.sleep(TimeSleep);
            }

        } catch (NoSuchPortException e) {
            e.printStackTrace();
        } catch (PortInUseException e) {
            e.printStackTrace();
        } catch (UnsupportedCommOperationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            serialPort.close();
        }
    }

    //Сохранение в БД
    private void saveToBase(EventsLog log){
        Factory.getInstanse().getdEventsLog().addEventsLog(log);
    }

    //Подготовка и передача даннх в метод saveToBase
    private void setValueDav(double valueDav){
        EventsLog dav = new EventsLog();
        dav.setId_param(this.p);
        dav.setId_object(this.id_object);
        dav.setDate(getDate());
        dav.setTime(getTime());
        dav.setValue(valueDav);
        saveToBase(dav);
    }

    //Подготовка и передача даннх в метод saveToBase
    private void setValueTemp(double valueTemp){
        EventsLog temp = new EventsLog();
        temp.setId_param(this.t);
        temp.setId_object(this.id_object);
        temp.setDate(getDate());
        temp.setTime(getTime());
        temp.setValue(valueTemp);
        saveToBase(temp);
    }

    //Подготовка и передача даннх в метод saveToBase
    private void setValueRH(double valueRH){
        EventsLog vRH = new EventsLog();
        vRH.setId_param(this.rh);
        vRH.setId_object(this.id_object);
        vRH.setDate(getDate());
        vRH.setTime(getTime());
        vRH.setValue(valueRH);
        saveToBase(vRH);
    }

    //Получание Даты события, берется с компа.
    private Date getDate(){
        Calendar c = Calendar.getInstance();
        GregorianCalendar calendar = new GregorianCalendar(c.get(Calendar.YEAR),c.get(Calendar.MONTH), c.get(Calendar.DATE));
        Date hireDay = calendar.getTime();
        return hireDay;
    }

    //Получение времени события, берется с компа.
    private Time getTime(){
        Time time = new Time(new Date().getTime());
        return time;
    }

}