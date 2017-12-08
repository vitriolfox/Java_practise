package com.flowacademy.uszoda;

import com.flowacademy.uszoda.exceptions.UszikException;

import java.io.Serializable;

public abstract  class Uszo implements Serializable{
    protected String nev;
    protected int teljesitmeny;
    protected String nemzetiseg;

    public Uszo(String nev, int teljesitmeny, String nemzetiseg) {
        this.nev = nev;
        this.teljesitmeny = teljesitmeny;
        this.nemzetiseg = nemzetiseg;
    }

    public String getNev() {
        return nev;
    }

    public int getTeljesitmeny() {
        return teljesitmeny;
    }

    public String getNemzetiseg() {
        return nemzetiseg;
    }

    public abstract double uszik() throws UszikException;

    @Override
    public String toString() {
        return  nev +
                ", teljesitmeny: " + teljesitmeny +
                ", nemzetiseg: " + nemzetiseg;
    }
}
