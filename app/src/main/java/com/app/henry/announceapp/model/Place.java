package com.app.henry.announceapp.model;

/**
 * Created by henry on 02/04/17.
 */

public class Place {
    private int     id;
    private String  name;
    private String  location;
    private int     img;

    public Place(String name, String location, int img) {
        this.name       = name;
        this.location   = location;
        this.img        = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
