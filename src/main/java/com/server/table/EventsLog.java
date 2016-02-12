package com.server.table;


import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "Events")
public class EventsLog {

    @Id
    @Column(name = "id_events")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_event;

    @Column(name = "id_parameter")
    private int id_param;

    @Column(name = "id_object")
    private int id_object;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private Time time;

    @Column(name = "value")
    private double value;

    public void setTime(Time time) {
        this.time = time;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public void setId_param(int id_param) {
        this.id_param = id_param;
    }

    public void setId_object(int id_object) {
        this.id_object = id_object;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
