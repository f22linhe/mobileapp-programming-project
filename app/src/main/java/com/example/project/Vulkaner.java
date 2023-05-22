package com.example.project;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("WeakerAccess")
public class Vulkaner {

    //Member variables and state
    private String ID;
    private String name;
    private String location;
    @SerializedName("size")
    private int size;
    private String category;


    //Constructors
    public Vulkaner(String ID, String name, String location, int size, String category) {
        this.ID = ID;
        this.name = name;
        this.location = location;
        this.size = size;
        this.category = category;
    }

    //Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Object getInteger() {
        return size;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}