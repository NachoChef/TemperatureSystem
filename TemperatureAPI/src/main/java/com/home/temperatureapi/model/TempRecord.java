package com.home.temperatureapi.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "temps")
public class TempRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "temp")
    private String temperature;

    @Column(name = "create_time")
    private Timestamp createTimestamp;

    @PrePersist
    protected void onCreate() {
        createTimestamp = new Timestamp(System.currentTimeMillis());
        ;
    }
}
