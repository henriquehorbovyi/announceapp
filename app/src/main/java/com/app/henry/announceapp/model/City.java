package com.app.henry.announceapp.model;
/**
 * Created by Henry on 28/03/2017.
 */

public class City {
    private String name;
    private String location;
    private String cep;

    public City(){}
    public City(String name, String location, String cep){
        this.name       = name;
        this.location   = location;
        this.cep        = cep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
}
