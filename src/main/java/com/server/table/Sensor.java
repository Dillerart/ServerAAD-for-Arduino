package com.server.table;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sensor")
public class Sensor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "id_measurement")
    private int id_measurement;

    @Column(name = "sensor")
    private String sensor;

    @Column(name = "identifier_sensor")
    private int identifier_sensor;

    @OneToMany(mappedBy = "sensor")
    private Set<EventsLog> eventsLogs = new HashSet<EventsLog>();

    @OneToMany(mappedBy = "sensor")
    private Set<Measurement> measurements = new HashSet<Measurement>();

    public Set<EventsLog> getEventsLogs() {
        return eventsLogs;
    }

    public void setEventsLogs(Set<EventsLog> eventsLogs) {
        this.eventsLogs = eventsLogs;
    }

    public Set<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(Set<Measurement> measurements) {
        this.measurements = measurements;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_measurement() {
        return id_measurement;
    }

    public void setId_measurement(int id_measurement) {
        this.id_measurement = id_measurement;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public int getIdentifier_sensor() {
        return identifier_sensor;
    }

    public void setIdentifier_sensor(int identifier_sensor) {
        this.identifier_sensor = identifier_sensor;
    }
}
