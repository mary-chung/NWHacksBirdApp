package com.example.birdapp;

public class Bird {
    private String cname;
    private String sname;
    private String size;
    private String funfact;
    private String habitat;
    private String diet;
    private String appearance;

    public Bird(String cname, String sname, String size, String funfact, String habitat, String diet, String appearance) {
        this.cname = cname;
        this.sname = sname;
        this.size = size;
        this.funfact = funfact;
        this.habitat = habitat;
        this.diet = diet;
        this.appearance = appearance;

    }

    public String getCname() {
        return cname;
    }

    public String getSname() {
        return sname;
    }

    public String getSize() {
        return size;
    }

    public String getFunfact() {
        return funfact;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getDiet() {
        return diet;
    }

    public String getAppearance() {
        return appearance;
    }
}
