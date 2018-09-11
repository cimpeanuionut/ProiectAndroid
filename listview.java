package com.example.gabriel.myfirstgame;

/**
 * Created by gabriel on 27/01/2017.
 */

public class listview {

    private String nume;
    private int scor;
    private int distanta;

    public listview(String nume, int scor, int distanta) {
        this.nume = nume;
        this.scor = scor;
        this.distanta = distanta;
    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getScor() {
        return scor;
    }

    public void setScor(int scor) {
        this.scor = scor;
    }

    public int getDistanta() {
        return distanta;
    }

    public void setDistanta(int distanta) {
        this.distanta = distanta;
    }
}
