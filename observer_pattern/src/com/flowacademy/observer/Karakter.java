package com.flowacademy.observer;

import java.util.Observable;
import java.util.Observer;

public class Karakter implements Observer{
    private String nev;
    private String huva;

    public Karakter(String nev, String huva) {
        this.nev = nev;
        this.huva = huva;
    }

    public String getNev() {
        return nev;
    }

    public String getHuva() {
        return huva;
    }

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof Lovaskocsi){
            if (this.huva.equals(o)) {
                ((Lovaskocsi) observable).kiszall(this);
            }
        }
    }

    @Override
    public String toString() {
        return nev;
    }
}
