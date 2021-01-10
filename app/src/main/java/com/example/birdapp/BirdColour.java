package com.example.birdapp;

public class BirdColour {

    private String cname;
    private String colour;

    public BirdColour(String cname, String colour) {
        this.cname = cname;
        this.colour = colour;
    }

    public String getCname() {
        return cname;
    }

    public String getColour() {
        return colour;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
