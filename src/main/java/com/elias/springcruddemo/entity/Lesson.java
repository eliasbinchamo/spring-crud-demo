package com.elias.springcruddemo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String title;
    @Column()
    LocalDateTime deliveredOn;

    public LocalDateTime getDeliveredOn() {
        return deliveredOn;
    }

    public void setDeliveredOn(LocalDateTime deliveredOn) {
        this.deliveredOn = deliveredOn;
    }
    public Lesson() {
    }
    public Lesson(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String titl) {
        this.title = titl;
    }

    @Override
    public String toString() {
        return "{\"id\":"+id+","+"\"title\":\""+title+"\","+"\"deliveredOn\":\""+deliveredOn.toString()+"\"}";
    }
}
