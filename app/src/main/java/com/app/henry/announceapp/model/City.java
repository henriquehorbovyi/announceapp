package com.app.henry.announceapp.model;
/**
 * Created by Henry on 28/03/2017.
*/
public class City {
    private int     id;
    private String  name;
    private String  location;

    public City(){}
    public City(String name, String location){
        this.name       = name;
        this.location   = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int name) {
        this.id = id;
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

}
