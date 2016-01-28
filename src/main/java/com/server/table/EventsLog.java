package com.server.table;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "events_log")
public class EventsLog {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "id_sensor")
    private int id_sensor;

    @Column(name = "dateMessenge")
    private Date dateMessenge;

    @Column(name = "event")
    private String event;

    @ManyToOne
    @JoinColumn(name = "id")
    private Sensor sensor;

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_sensor() {
        return id_sensor;
    }

    public void setId_sensor(int id_sensor) {
        this.id_sensor = id_sensor;
    }

    public Date getDateMessenge() {
        return dateMessenge;
    }

    public void setDateMessenge(Date dateMessenge) {
        this.dateMessenge = dateMessenge;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
