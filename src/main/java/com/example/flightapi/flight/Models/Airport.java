package com.example.flightapi.flight.Models;


import jakarta.persistence.*;

@Entity
@Table(name = "airporttable",schema = "flightdb")
public class Airport {

    public Airport(Integer id, String city) {
        this.id = id;
        this.city = city;
    }

    @Id
    @GeneratedValue
    Integer id;
    String city;

    public Airport() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
