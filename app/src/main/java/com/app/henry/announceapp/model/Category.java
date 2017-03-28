package com.app.henry.announceapp.model;
/**
 * Created by Eduardo on 26/03/2017.
 */
public class Category {

    private String  name;
    private int     image;

    public Category(){}
    public Category(String name,int image){
        this.name  = name;
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setImage(int image) {
        this.image = image;
    }
    public int getImage() {
        return image;
    }
}
