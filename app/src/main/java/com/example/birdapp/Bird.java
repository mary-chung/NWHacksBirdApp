package com.example.birdapp;

public class Bird {
    private String cname;
    private String sname;
    private String size;
    private String funfact;
    private String habitat;
    private String sizerange;
    private String diet;
    private String appearance;

    public Bird() {
    }


    public Bird(String cname, String sname, String size, String funfact, String habitat, String sizerange, String diet, String appearance) {
        this.cname = cname;
        this.sname = sname;
        this.size = size;
        this.funfact = funfact;
        this.habitat = habitat;
        this.sizerange = sizerange;
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

    public String getSizerange() {
        return sizerange;
    }

    public String getDiet() {
        return diet;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setFunfact(String funfact) {
        this.funfact = funfact;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void setSizerange(String sizerange) {
        this.sizerange = sizerange;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }
}
