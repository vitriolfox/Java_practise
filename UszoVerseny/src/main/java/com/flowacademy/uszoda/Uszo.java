package com.flowacademy.uszoda;

import com.flowacademy.uszoda.exceptions.UszikException;

import java.io.Serializable;

public abstract  class Uszo implements Serializable{
    protected String nev;
    protected int teljesitmeny;
    protected String nemzetiseg;

    public Uszo() {
    }

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

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setTeljesitmeny(int teljesitmeny) {
        this.teljesitmeny = teljesitmeny;
    }

    public void setNemzetiseg(String nemzetiseg) {
        this.nemzetiseg = nemzetiseg;
    }

    public abstract double uszik() throws UszikException;

    @Override
    public String toString() {
        return  nev +
                ", teljesitmeny: " + teljesitmeny +
                ", nemzetiseg: " + nemzetiseg;
    }
}
