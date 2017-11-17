package com.flowacademy.observer;

import java.util.Observable;
import java.util.Observer;

public class Karakter implements Observer{
    private String nev;

    public Karakter(String nev) {
        this.nev = nev;
    }

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof Lovaskocsi){
            ((Lovaskocsi) observable).kiszall(this);
        }
    }
}
