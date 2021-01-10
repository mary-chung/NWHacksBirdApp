package com.example.birdapp;

public class BirdLoc {

    private String cname;
    private String loc;

    public BirdLoc(String cname, String loc) {
        this.cname = cname;
        this.loc = loc;
    }

    public String getCname() {
        return cname;
    }

    public String getLoc() {
        return loc;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
