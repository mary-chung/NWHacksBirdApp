package com.example.birdapp;

import java.util.ArrayList;

public class Questionnaire {
    private static Questionnaire questionnaire;
    private String location;
    private ArrayList<String> colours;
    private String size;

    private Questionnaire() {
        // idk what to put
    }

    // call this to access from different classes
    public static Questionnaire getInstance() {
        if (questionnaire == null)
            questionnaire = new Questionnaire();

        return questionnaire;
    }

    void setLocation(String location) {
        this.location = location;
    }

    void setColours(ArrayList<String> colours) {
        this.colours = colours;
    }

    void setSize(String size) {
        this.size = size;
    }

    String BuildQuery() {
        return ""; //stub
    }
}
