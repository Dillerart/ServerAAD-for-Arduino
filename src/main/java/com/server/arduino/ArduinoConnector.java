package com.server.arduino;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import gnu.io.*;

public class ArduinoConnector implements Runnable {

    private BufferedReader bRead = null;

    private final int TIME_OUT = 2000;

    private final int DATA_RATE = 9600;

    private SerialPort serialPort;

    private String arduinoText;

    private InputStreamReader input = null;


    private final String PORT_NAME = "/dev/ttyUSB2";

    public void run() {
        CommPortIdentifier portID = null;
        try {
            portID = CommPortIdentifier.getPortIdentifier(PORT_NAME);
            serialPort = (SerialPort) portID.open(this.getClass().getName(), TIME_OUT);
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            bRead = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            while ((arduinoText = bRead.readLine()) !=null){
                System.out.println(arduinoText);
            }
            Thread.sleep(1000);
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
        }
    }


}
